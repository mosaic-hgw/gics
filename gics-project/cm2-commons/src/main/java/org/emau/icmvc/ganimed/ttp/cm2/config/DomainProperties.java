package org.emau.icmvc.ganimed.ttp.cm2.config;

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


/**
 * possible properties for a consent domain
 * 
 * @author geidell
 * 
 */
public enum DomainProperties {

	/**
	 * if there are more than one signed policies for a policy, instead the most recent, the one with the highest version number is considered the current one.<br>
	 * default = false
	 */
	TAKE_HIGHEST_VERSION_INSTEAD_OF_NEWEST,
	/**
	 * if set to true, a single signed policy with the state "declined" voids all signed policies for that policy (even if they are newer).<br>
	 * default = false
	 */
	REVOKE_IS_PERMANENT,
	/**
	 * by default, if at least one policy is accepted within a consent document, a scan of either patient and physician signature or of the whole document is required.
	 * set this property to true to skip this validation check.<br>
	 * default = false
	 */
	SCANS_ARE_NOT_MANDATORY_FOR_ACCEPTED_CONSENTS;
}
