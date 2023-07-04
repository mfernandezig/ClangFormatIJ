//#***************************************************************************
//# freenet Technologie und Prozesse Source File: Settings.java
//# Copyright (c) 1996-2023 by freenet DLS GmbH
//# All rights reserved.
//#***************************************************************************
package io.probst.idea.clangformat.clangformatij.plugin;

import com.intellij.ide.util.PropertiesComponent;

import lombok.Getter;


/********************************************************************
 * DOCME
 *
 * @author angel
 */
@Getter
public class Settings
{
	//~ Static fields/initializers ---------------------------------------------------------------------------------------------

	static final String CF_BINARY_PROP = ClangFormatConfigurable.class.getName() + ".clangFormatBinary";
	static final String CF_PATH_PROP = ClangFormatConfigurable.class.getName() + ".path";
	static final String CF_VCS_FORMAT_PROP = ClangFormatConfigurable.class.getName() + ".vcs_format";

	//~ Instance fields --------------------------------------------------------------------------------------------------------

	final String clangFormatBinary;
	final String path;
	final boolean updateOnlyChangedText;

	//~ Constructors -----------------------------------------------------------------------------------------------------------

	/***************************************
	 * Erstellt eine neue Settings Instanz.
	 */
	Settings()
	{
		PropertiesComponent props = PropertiesComponent.getInstance();
		clangFormatBinary = props.getValue(CF_BINARY_PROP, "clang-format");
		path = props.getValue(CF_PATH_PROP);
		updateOnlyChangedText = props.getBoolean(CF_VCS_FORMAT_PROP, false);
	}

	//~ Methods ----------------------------------------------------------------------------------------------------------------

	/***************************************
	 * DOCME
	 *
	 * @return DOCME
	 */
	static Settings get()
	{
		return new Settings();
	}

	/***************************************
	 * DOCME
	 *
	 * @param  clangFormatBinary     DOCME
	 * @param  path                  DOCME
	 * @param  updateOnlyChangedText DOCME
	 *
	 * @return DOCME
	 */
	static Settings update(String clangFormatBinary, String path, boolean updateOnlyChangedText)
	{
		if ("".equals(clangFormatBinary))
		{
			clangFormatBinary = "clang-format";
		}

		if ("".equals(path))
		{
			path = null;
		}

		PropertiesComponent props = PropertiesComponent.getInstance();
		props.setValue(CF_BINARY_PROP, clangFormatBinary, "clang-format");
		props.setValue(CF_PATH_PROP, path, null);
		props.setValue(CF_VCS_FORMAT_PROP, updateOnlyChangedText);
		return get();
	}
}
