package org.emau.icmvc.ganimed.ttp.cm2.frontend.model;

/*-
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

import org.emau.icmvc.ganimed.ttp.cm2.dto.ConsentTemplateKeyDTO;
import org.emau.icmvc.ganimed.ttp.cm2.dto.ModuleKeyDTO;
import org.emau.icmvc.ganimed.ttp.cm2.dto.PolicyKeyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateTreeNode
{
	public Logger logger = LoggerFactory.getLogger(getClass());

	private Object key;
	private Boolean mandatory = true;
	private Type type;

	public TemplateTreeNode(Object key)
	{
		this.key = key;
		initType();
	}

	public TemplateTreeNode(Object key, Boolean mandatory)
	{
		this.key = key;
		this.mandatory = mandatory;
		initType();
	}

	private void initType()
	{
		if (key instanceof ConsentTemplateKeyDTO)
		{
			type = Type.TEMPLATE;
		}
		else if (key instanceof ModuleKeyDTO)
		{
			type = Type.MODULE;
		}
		else if (key instanceof PolicyKeyDTO)
		{
			type = Type.POLICY;
		}
		else
		{
			logger.error("Cannot parse object for template tree.");
		}
	}

	public Object getKey()
	{
		return key;
	}

	public Boolean getMandatory()
	{
		return mandatory;
	}

	public Type getType()
	{
		return type;
	}

	public enum Type
	{
		TEMPLATE, MODULE, POLICY
	};
}
