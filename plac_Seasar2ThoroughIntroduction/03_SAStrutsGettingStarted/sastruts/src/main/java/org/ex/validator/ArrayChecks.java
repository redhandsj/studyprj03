package org.ex.validator;

import java.lang.reflect.Array;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.log.Logger;
import org.seasar.struts.validator.S2FieldChecks;

public class ArrayChecks extends S2FieldChecks{

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(ArrayChecks.class);

	@SuppressWarnings("rawtypes")
	public static boolean validateRequiredArray(Object bean, ValidatorAction validatorAction, Field  field, ActionMessages errors, Validator validator, HttpServletRequest request) {
		Object value = null;
		try {
			// アクションフォームから値を取得
			value = PropertyUtils.getProperty(bean, field.getProperty());
		}catch(Exception ex) {
			logger.error(ex.getMessage(),ex);
		}

		// nullの場合にエラー
		if(value == null) {
			addError(errors, field, validator, validatorAction, request);
			return false;
		}

		// 配列の場合
		if(value.getClass().isArray()) {
			// サイズが０の場合エラー
			if(Array.getLength(value) == 0) {
				addError(errors, field, validator, validatorAction, request);
				return false;
			}
		}

		// リストの場合
		if(value instanceof List) {
			// サイズが０の場合エラー
			if(((List)value).isEmpty()) {
				addError(errors, field, validator, validatorAction, request);
				return false;
			}
		}

		return false;
	}
}
