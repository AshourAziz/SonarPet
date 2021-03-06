/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.echopet.compat.api.plugin;

import javax.annotation.Nullable;

import com.dsh105.commodus.config.YAMLConfig;
import com.dsh105.echopet.compat.api.config.ConfigOptions;
import com.dsh105.echopet.compat.api.entity.IEntityPet;
import com.dsh105.echopet.compat.api.plugin.hook.IVanishProvider;
import com.dsh105.echopet.compat.api.plugin.hook.IWorldGuardProvider;

import net.techcable.sonarpet.HookRegistry;
import net.techcable.sonarpet.nms.INMS;
import com.zaxxer.hikari.HikariDataSource;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

public interface IEchoPetPlugin extends Plugin {

    public INMS getSpawnUtil();

    public String getPrefix();

    public String getCommandString();

    public String getAdminCommandString();

    HookRegistry getHookRegistry();

    public IPetManager getPetManager();

    public ISqlPetManager getSqlPetManager();

    public HikariDataSource getDbPool();

    public IVanishProvider getVanishProvider();

    public IWorldGuardProvider getWorldGuardProvider();

    public YAMLConfig getPetConfig();

    public YAMLConfig getMainConfig();

    public YAMLConfig getLangConfig();

    public ConfigOptions getOptions();

    public boolean isUsingNetty();

    public boolean isUpdateAvailable();

    public String getUpdateName();

    public long getUpdateSize();

    default boolean isPet(Entity e) {
        return getPetEntity(e) != null;
    }

    @Nullable
    public IEntityPet getPetEntity(Entity e);
}