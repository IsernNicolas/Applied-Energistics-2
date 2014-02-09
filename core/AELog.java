package appeng.core;

import org.apache.logging.log4j.Level;

import appeng.core.features.AEFeature;
import appeng.util.Platform;
import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class AELog
{

	public static cpw.mods.fml.relauncher.FMLRelaunchLog instance = cpw.mods.fml.relauncher.FMLRelaunchLog.log;

	private AELog() {
	}

	private static void log(Level level, String format, Object... data)
	{
		if ( AEConfig.instance == null || AEConfig.instance.isFeatureEnabled( AEFeature.Logging ) )
		{
			FMLRelaunchLog.log( "AE2:" + (Platform.isServer() ? "S" : "C"), level, format, data );
		}
	}

	public static void severe(String format, Object... data)
	{
		log( Level.ERROR, format, data );
	}

	public static void warning(String format, Object... data)
	{
		log( Level.WARN, format, data );
	}

	public static void info(String format, Object... data)
	{
		log( Level.INFO, format, data );
	}

	public static void grinder(String o)
	{
		log( Level.DEBUG, "grinder: " + o );
	}

	public static void error(Throwable e)
	{
		if ( AEConfig.instance.isFeatureEnabled( AEFeature.Logging ) )
		{
			severe( "Error: " + e.getMessage() );
			e.printStackTrace();
		}
	}
}
