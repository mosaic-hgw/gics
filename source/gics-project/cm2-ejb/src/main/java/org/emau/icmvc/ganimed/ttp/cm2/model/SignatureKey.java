package org.emau.icmvc.ganimed.ttp.cm2.model;

/*
 * ###license-information-start###
 * gICS - a Generic Informed Consent Service
 * __
 * Copyright (C) 2014 - 2018 The MOSAIC Project - Institut fuer Community
 * 							Medicine of the University Medicine Greifswald -
 * 							mosaic-projekt@uni-greifswald.de
 * 
 * 							concept and implementation
 * 							l.geidel
 * 							web client
 * 							a.blumentritt, m.bialke
 * 
 * 							Selected functionalities of gICS were developed as part of the MAGIC Project (funded by the DFG HO 1937/5-1).
 * 
 * 							please cite our publications
 * 							http://dx.doi.org/10.3414/ME14-01-0133
 * 							http://dx.doi.org/10.1186/s12967-015-0545-6
 * 							http://dx.doi.org/10.3205/17gmds146
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


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * zusammengesetzter primaerschluessel fuer eine unterschrift
 * 
 * @author geidell
 *
 */
@Embeddable
public class SignatureKey implements Serializable {

	private static final long serialVersionUID = -522166246474230411L;
	@Column(insertable = false, updatable = false)
	private ConsentKey consentKey;
	private SignatureType type;

	public SignatureKey() {
	}

	public SignatureKey(ConsentKey consentKey, SignatureType type) {
		this.consentKey = consentKey;
		this.type = type;
	}

	public ConsentKey getConsentKey() {
		return consentKey;
	}

	public SignatureType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consentKey == null) ? 0 : consentKey.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignatureKey other = (SignatureKey) obj;
		if (consentKey == null) {
			if (other.consentKey != null)
				return false;
		} else if (!consentKey.equals(other.consentKey))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("signature type '");
		sb.append(type.toString());
		sb.append("' for ");
		sb.append(consentKey);
		return sb.toString();
	}
}
