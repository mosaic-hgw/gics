package org.emau.icmv.ganimed.ttp.cm2.frontend.validator;

/*
 * ###license-information-start###
 * gICS - a Generic Informed Consent Service
 * __
 * Copyright (C) 2014 - 2017 The MOSAIC Project - Institut fuer Community Medicine der
 * 							Universitaetsmedizin Greifswald - mosaic-projekt@uni-greifswald.de
 * 							concept and implementation
 * 							l. geidel
 * 							web client
 * 							g. weiher
 * 							a. blumentritt
 * 							please cite our publications
 * 							http://dx.doi.org/10.3414/ME14-01-0133
 * 							http://dx.doi.org/10.1186/s12967-015-0545-6
 * __
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * ###license-information-end###
 */

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.emau.icmvc.ganimed.ttp.cm2.dto.PolicyDTO;
import org.primefaces.model.DualListModel;

/**
 * validates a DualListModel of PolicyDTO. Checks, if there are any duplicate Policies in the target List
 * 
 * @author weiherg
 * @author weiherg
 * 
 */
@ManagedBean(name = "policiesValidator")
@RequestScoped
public class PoliciesValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		@SuppressWarnings("unchecked")
		ArrayList<PolicyDTO> policies = new ArrayList<PolicyDTO>(((DualListModel<PolicyDTO>) arg2).getTarget());
		for (int i = 0; i < policies.size(); i++) {
			for (int j = i + 1; j < policies.size(); j++) {
				if (policies.get(i).getKey().getName().equals(policies.get(j).getKey().getName())) {
					ResourceBundle messages = ResourceBundle.getBundle("messages");
					Object[] args = { policies.get(i).getKey().getName() };
					throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, new MessageFormat(
							messages.getString("template.message.duplicatePolicy")).format(args), ""));
				}
			}
		}

	}

}
