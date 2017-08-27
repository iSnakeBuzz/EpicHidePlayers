package com.isnakebuzz.EpicHidePlayers.b;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class PlayerData{
  private static PlayerData instance;
  private File pluginDir;
  private File configFile;
  private FileConfiguration config;
  
    public void a(Plugin p){
        this.pluginDir = p.getDataFolder();
    
        this.configFile = new File(this.pluginDir, "PlayerData.yml");
        if (!this.configFile.exists()) {
            p.saveResource("PlayerData.yml", true);
        }
        this.config = YamlConfiguration.loadConfiguration(this.configFile);
    }
  
  public File getConfigFile()
  {
    return this.configFile;
  }
  
  public FileConfiguration getConfig()
  {
    return this.config;
  }
  
  public void saveConfig()
  {
    try
    {
      this.config.save(this.configFile);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
  
  public static PlayerData get()
  {
    if (instance == null) {
      instance = new PlayerData();
    }
    return instance;
  }
}