package com.huilian.petitcredit.base.pushmsg.utils.vlidationBean;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
//import javax.validation.ValidationException;  
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.bind.ValidationException;

import com.huilian.petitcredit.base.pushmsg.model.xmlvo.NetBookInfoList;

/**
 * @ClassName: VlidationUtil
 * @Description: 校验工具类
 * @author zhangyy
 * @date 2015-7-31 上午10:28:48
 */
public class VlidationUtil {

	private static Validator validator;

	static {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	/**
	 * @throws ValidationException @throws ValidationException @Description:
	 * 校验方法 @param t 将要校验的对象 @throws ValidationException void @throws
	 */
	public static <T> void validate(T t) throws ValidationException {
		Set<ConstraintViolation<T>> set = validator.validate(t);
		if (set.size() > 0) {
			StringBuilder validateError = new StringBuilder();
			for (ConstraintViolation<T> val : set) {
				validateError.append(val.getMessage() + " ;");
			}
			throw new ValidationException(validateError.toString());
		}
	}

	public static void main(String[] args) {
		NetBookInfoList person = new NetBookInfoList();
		try {
			VlidationUtil.validate(person);
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
		// 输出结果为：test不能为空 ;用户ID不能为空 ;用户姓名不能为空dd ;
	}

}