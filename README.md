# petitloan
ZeroC IceGrid微服务框架实践-小贷款系统报文推送上报服务


一、概念
slice: ice提供了自己的接口定义语言。用来定义rpc的接口和对象。

ice.object: rpc调用的接口必须继承自ice.Object

servant：ice.Object的实例化对象叫做servant，rpc调用的就是servant对象，因此servant需要线程安全

endpoints：客户端rpc调用servant的地址

icebox：servant的容器

icenode：icebox的容器

registry：注册中心，负责管理icenode的注册，负责和发布。

二、部署
步骤：

启动registry

启动node，注册到registry

将代码部署到node服务器上

将应用描述文件应用到registry上，node上将自动启动application

三、配置文件
registry配置文件一个:registry.cfg

node配置文件n个：node1.cfg, node2.cfg

应用描述文件app.xml

配置文件详情：

registry.cfg

# grid实例名
IceGrid.InstanceName=SzcIceGrid
#客户端连接到注册中心的地址
IceGrid.Registry.Client.Endpoints=tcp -p 4061
IceGrid.Registry.Server.Endpoints=tcp
IceGrid.Registry.Internal.Endpoints=tcp
IceGrid.Registry.PermissionsVerifier=SzcIceGrid/NullPermissionsVerifier
IceGrid.Registry.AdminPermissionsVerifier=SzcIceGrid/NullPermissionsVerifier
#注册中心数据保存路径,需要手动创建文件夹
IceGrid.Registry.Data=/data/shizc/Desktop/ice/registry
IceGrid.Registry.DynamicRegistration=1
Ice.Admin.InstanceName=AdminInstance
Ice.Admin.ServerId=Admin
node1.cfg

# 注册中心地址
Ice.Default.Locator=SzcIceGrid/Locator:tcp -h 192.168.7.7 -p 4061
#node名
IceGrid.Node.Name=node1
IceGrid.Node.Endpoints=tcp
#node存储路径
IceGrid.Node.Data=/data/shizc/Desktop/ice/nodes/node1
IceGrid.Node.Output=/data/shizc/Desktop/ice/nodes/node1
IceGrid.Node.CollocateRegistry=0
#IceGrid.Node.Trace.Replica=2
#IceGrid.Node.Trace.Activator=3
#IceGrid.Node.Trace.Adapter=3
#IceGrid.Node.Trace.Server=3
node2.cfg

# 注册中心地址
Ice.Default.Locator=SzcIceGrid/Locator:tcp -h 192.168.7.7 -p 4061

IceGrid.Node.Name=node2
IceGrid.Node.Endpoints=tcp
IceGrid.Node.Data=/data/shizc/Desktop/ice/nodes/node2
IceGrid.Node.Output=/data/shizc/Desktop/ice/nodes/node2
IceGrid.Node.CollocateRegistry=0
#IceGrid.Node.Trace.Replica=2
#IceGrid.Node.Trace.Activator=3
#IceGrid.Node.Trace.Adapter=3
#IceGrid.Node.Trace.Server=3
app.xml

<icegrid>
  <application name="FileSystemApp">
    <properties id="MultiThreaded" >
      <property name="Ice.PrintStackTraces" value="1" ></property>
      <property name="IceSSL.Trace.Security" value="2" ></property>
      <property name="Ice.ThreadPool.Client.Size" value="2" ></property>
      <property name="Ice.ThreadPool.Client.SizeMax" value="50" ></property>
      <property name="Ice.ThreadPool.Server.Size" value="10" ></property>
      <property name="Ice.ThreadPool.Server.SizeMax" value="100" ></property>
      <property name="IceBox.InheritProperties" value="1" ></property>
      <property name="Ice.Override.ConnectTimeout" value="5000" ></property>
      <property name="Ice.Override.Timeout" value="10000" ></property>
      <property name="IceBox.Trace.ServiceObserver" value="1" ></property>
      <property name="Ice.Default.LocatorCacheTimeout" value="300" ></property>
      <property name="Ice.BackgroundLocatorCacheUpdates" value="1" ></property>
    </properties>
    <!-- 配置模板 -->
    <server-template id="FileSystemServerIceBoxTemplate">
        <parameter name="index" default="0"></parameter>
        <!-- exe指定java启动 -->
        <icebox id="FileSystemServerIceBox${index}" exe="java" activation="on-demand" >
          <properties>
            <properties refid="MultiThreaded" />
          </properties>
          <option>-Xmx512M</option>
          <!-- icebox启动main方法 -->
          <option>IceBox.Server</option>
          <!-- 开发的代码路径 -->
          <env>CLASSPATH=.:/usr/share/java/*:/data/shizc/Desktop/ice/bin</env>
          <!-- entry指定icebox启动的service, replica-group指定endpoints组 -->
          <service name="FilesystemService" entry="service.FilesystemService">
            <adapter name="FilesystemService" id="FilesystemService${index}" endpoints="default" replica-group="FilesystemServiceRep" ></adapter>
          </service>
        </icebox>
    </server-template>
    
    <replica-group id="FilesystemServiceRep">
      <load-balancing type="round-robin" n-replicas="0" />
      <!-- 指定servant的名字 -->
      <object identity="RootDir" type="::filesystem::Directory"></object>
      <object identity="iamfile" type="::filesystem::File"></object>
    </replica-group>
    <!-- 每个node定义2个icebox -->
    <node name="node1">
      <server-instance template="FileSystemServerIceBoxTemplate" index="11"></server-instance>
      <server-instance template="FileSystemServerIceBoxTemplate" index="12"></server-instance>
    </node>
    <node name="node2">
      <server-instance template="FileSystemServerIceBoxTemplate" index="21"></server-instance>
      <server-instance template="FileSystemServerIceBoxTemplate" index="22"></server-instance>
    </node>
  </application>
</icegrid>
四、启动
icegridregistry --Ice.Config=registry.cfg

icegridnode --Ice.Config=node1.cfg

icegridnode --Ice.Config=node2.cfg

icegridadmin --Ice.Config=node1.cfg

登陆后

application add app.xml

五、代码
定义slice：

[["java:package:com.asto"]]
module filesystem{
	interface Node{
		string name();
	};
	
	exception GenericError{
		string reason;
	};
	
	sequence<string> Lines;
	
	interface File extends Node{
		Lines read();
		void write(Lines text) throws GenericError;
	};
	
	sequence<Node*> NodeSeq;
	
	interface Directory extends Node{
		NodeSeq list();
	};
	
	interface FileSys{
		Directory* getRoot();
	};
	
};
通过eclipse插件或命令slice2java转换成java类

实现Directory接口和File接口

package servant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.asto.filesystem.NodePrx;
import com.asto.filesystem.NodePrxHelper;
import com.asto.filesystem._DirectoryDisp;

import Ice.Current;

public class DirectoryI extends _DirectoryDisp {

	public static Ice.ObjectAdapter _adapter;
	public String _name;
	public DirectoryI _parent;
	public List<NodePrx> _content = new ArrayList<NodePrx>();

	public DirectoryI(String _name, DirectoryI _parent) {
		super();
		this._name = _name;
		this._parent = _parent;
		Ice.Identity theId = Ice.Util.stringToIdentity(_parent == null ? "RootDir" : UUID.randomUUID().toString());
		_adapter.add(this, theId);
		// 自身的代理
		NodePrx theNode = NodePrxHelper.uncheckedCast(_adapter.createProxy(theId));
		// 把自己添加到父目录的子节点中
		if (_parent != null) {
			_parent.addChild(theNode);
		}
	}

	@Override
	public NodePrx[] list(Current __current) {
		System.out.println("[DirectoryI]invoke list @" + Thread.currentThread().getName());
		NodePrx[] retList = new NodePrx[_content.size()];
		retList = _content.toArray(retList);
		return retList;
	}

	@Override
	public String name(Current __current) {
		System.out.println("[DirectoryI]invoke name @"+ Thread.currentThread().getName());
		return _name;
	}

	void addChild(NodePrx child) {
		System.out.println("[DirectoryI]invoke addChild @"+ Thread.currentThread().getName());
		_content.add(child);
	}

}


package servant;

import java.util.UUID;

import com.asto.filesystem.GenericError;
import com.asto.filesystem.NodePrx;
import com.asto.filesystem.NodePrxHelper;
import com.asto.filesystem._FileDisp;

import Ice.Current;

public class FileI extends _FileDisp {
	public static Ice.ObjectAdapter _adapter;
	public String _name;
	public DirectoryI _parent;
	public String[] _lines;

	public FileI(String _name, DirectoryI _parent) {
		super();
		this._name = _name;
		this._parent = _parent;
		assert(_parent != null);
		String identiyName = UUID.randomUUID().toString();
		if("README".equalsIgnoreCase(_name)){
			identiyName = "iamfile";
		}
		System.out.println("FileI'identiy:"+identiyName);
		Ice.Identity theId = Ice.Util.stringToIdentity(identiyName);
		_adapter.add(this, theId);
		NodePrx theNode = NodePrxHelper.uncheckedCast(_adapter.createProxy(theId));
		_parent.addChild(theNode);
	}

	@Override
	public String[] read(Current __current) {
		System.out.println("[FileI]invoke read @"+ Thread.currentThread().getName());
		return _lines;
	}

	@Override
	public void write(String[] text, Current __current) throws GenericError {
		System.out.println("[FileI]invoke write @"+ Thread.currentThread().getName());
		_lines = text;
	}

	@Override
	public String name(Current __current) {
		System.out.println("[FileI]invoke name @"+ Thread.currentThread().getName());
		return _name;
	}

}
这2个接口的实现类中都包含了一个Ice.ObjectAdapter, servant要通过adapter对外提供服务。

在构造方法中，将自身的实例（servant）添加进adapter中。

实现Icebox的的Service接口，

package service;

import com.asto.filesystem.GenericError;

import Ice.Communicator;
import IceBox.Service;
import servant.DirectoryI;
import servant.FileI;

public class FilesystemService implements Service {
	private Ice.ObjectAdapter _adapter;
	@Override
	public void start(String name, Communicator communicator, String[] args) {
		_adapter = communicator.createObjectAdapter(name);
		DirectoryI._adapter = _adapter;
		FileI._adapter = _adapter;
		DirectoryI root = new DirectoryI("/", null);
		FileI file = new FileI("README", root);
		String[] text = new String[] { "This file system contain a collection of poetry." };
		try {
			file.write(text);
		} catch (GenericError e) {
			System.err.println(e.reason);
		}

		DirectoryI coleridge = new DirectoryI("Coleridge", root);
		file = new FileI("Kubla_Khan", coleridge);
		text = new String[] { "In Xanadu did Kubla Khan", "A stately pleasure-dome decree:", "Where Alph, the sacred river, ran", "Through caverns measureless to man", "Down to a sunless sea." };
		try {
			file.write(text);
		} catch (GenericError e) {
			System.err.println(e.reason);
		}

		_adapter.activate();
		System.out.println("FileSystemServer adapter activate @" + Thread.currentThread().getName());
	}

	@Override
	public void stop() {
		System.out.println(getClass().getName() + " _adapter destroy @" + Thread.currentThread().getName());
		if(_adapter != null){
			_adapter.destroy();
		}
	}

}
FileSystemService在app.xml中配置到Icebox中。

client调用：

public static void main(String[] args){
		Ice.Communicator ic  = null;
		try{
			ic = Ice.Util.initialize(args);
//			Ice.ObjectPrx basePrx = ic.stringToProxy("iamfile");
//			FilePrx detailPrx = FilePrxHelper.checkedCast(basePrx);
			Ice.ObjectPrx basePrx = ic.stringToProxy("RootDir");
			DirectoryPrx detailPrx = DirectoryPrxHelper.checkedCast(basePrx);
			if(detailPrx == null){
				System.err.println("filePrx is null");
				System.exit(1);
			}
			String name = detailPrx.name();
			System.out.println("fileName is :" + name);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ic != null){
				ic.shutdown();
				ic.waitForShutdown();
				ic.destroy();
			}
		}
		
		
	}
client运行需要添加一个配置文件，指定registry地址

client.cfg

Ice.Default.Locator=SzcIceGrid/Locator:tcp -h 192.168.7.7 -p 4061
在运行client的时候指定配置文件

java com.client.Client --Ice.Config=client.cfg
