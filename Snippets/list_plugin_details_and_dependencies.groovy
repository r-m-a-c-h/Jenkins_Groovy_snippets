/////////////////////////////////////////////////////////////////
/// /manage/pluginManager/                                    ///
/// List all plugins with dependencies                        ///
/////////////////////////////////////////////////////////////////


/// Script Console

def plugins = jenkins.model.Jenkins.instance.getPluginManager().getPlugins()
plugins.each { 
  println "${it.getShortName()} (${it.getVersion()}) => ${it.getDependencies()}"; 
  println "-------------------------"
}
