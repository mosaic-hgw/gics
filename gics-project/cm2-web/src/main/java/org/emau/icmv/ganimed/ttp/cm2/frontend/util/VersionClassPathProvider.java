package org.emau.icmv.ganimed.ttp.cm2.frontend.util;

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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Maps VersionConverters to labels
 * 
 * @author Weiher
 * 
 * 
 */
@ManagedBean(name = "ClassPathProvider")
@ApplicationScoped
public class VersionClassPathProvider {
	private ResourceBundle versionBundle;

	private Logger logger = LoggerFactory.getLogger(VersionClassPathProvider.class);

	/**
	 * retrieves data from Recource Bundles
	 */
	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		versionBundle = context.getApplication().getResourceBundle(context, "version_ref");
		if (logger.isDebugEnabled()) {
			logger.debug("initialising");
		}
	}

	public String convertClassPath(String fullPath) {
		String returnValue = fullPath;
		if (versionBundle.containsKey(fullPath)) {
			returnValue = versionBundle.getString(fullPath);
		} else {
			returnValue = "unkown format";
		}

		if (logger.isTraceEnabled()) {
			logger.trace("Class name for " + fullPath + " is: " + returnValue);
		}
		return returnValue;
	}

	public Map<String, Object> getVersionMap() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		for (String key : versionBundle.keySet()) {
			if (!key.equals("version_class_path")) {
				map.put(versionBundle.getString(key), key);
			}
		}
		return map;
	}
}
