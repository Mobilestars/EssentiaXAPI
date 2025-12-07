# 📘 EssentiaX API – Addon Development Guide

Welcome to the official **EssentiaX API**.  
This API allows developers to create **addons for EssentiaX** without needing access to the main plugin and **without using a plugin.yml**.  
EssentiaX itself is **closed source**, but the API is **public** so anyone can build extensions.

---

# ✨ Features
- Addons are **simple JAR files**
- Addons go into:

```bash
/plugins/EssentiaX/addons/
```

- No plugin.yml required  
- Easy API interface  
- Addons are fully managed by the internal EssentiaX AddonLoader

---

## 🟦 Gradle

Add the newest EsentiaX jar file in to the folder where your build.grdle is placed
Add this to your `build.gradle`:

```gradle
dependencies {
  compileOnly files('EssentiaX-VERSION.jar')
}
```

---

🟧 Maven

Add this to your `pom.xml`:
```xml
<dependencies>
    <dependency>
        <groupId>com.github.Mobilestars</groupId>
        <artifactId>EssentiaX-API</artifactId>
        <version>VERSION</version>
        <scope>provided</scope>
        <systemPath>${project.basedir}/libs/EssentiaX-VERSION.jar</systemPath>
    </dependency>
</dependencies>
```

Replace:
```java
VERSION → the released tag (e.g. v1.0.0)
```

---

🧩 Addon Structure

An EssentiaX addon consists of:

 1. a JAR file containing your code

 2. an addon.yml inside the JAR (instead of plugin.yml)

Directory structure:
```css
MyAddon/
 ├─ src/main/java/
 │   └─ your/package/MyAddon.java
 ├─ src/main/resources/
 │   └─ addon.yml
 └─ build.gradle or pom.xml
 ```

---

📝 addon.yml

```yml
This file is REQUIRED:
name: ExampleAddon
version: 1.0.0
main: your.package.MyAddon
author: YourName
```

⚠️ Must be placed in src/main/resources so it gets packed into the JAR.
⚠️ Do not include a plugin.yml — EssentiaX loads addons directly.

---

👨‍💻 Writing Your First Addon

Every addon must implement the EssentiaXAddon interface.

Example:
```java
package your.package;

import de.scholle.essentiax.EssentiaX;
import de.scholle.essentiax.addons.EssentiaXAddon;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyAddon implements EssentiaXAddon, Listener {

    private EssentiaX plugin;

    @Override
    public void onLoad(EssentiaX plugin) {
        this.plugin = plugin;
        plugin.getLogger().info("[MyAddon] Loading...");
    }

    @Override
    public void onEnable(EssentiaX plugin) {
        // Register events
        plugin.getServer().getPluginManager().registerEvents(this, plugin);

        plugin.getLogger().info("[MyAddon] Enabled!");
    }

    @Override
    public void onDisable(EssentiaX plugin) {
        plugin.getLogger().info("[MyAddon] Disabled.");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§aWelcome! (from MyAddon)");
    }
}
```
---

📤 Building the Addon
Gradle
```bash
./gradlew build
```
JAR output:
```bash
build/libs/
```
Maven
```go
mvn package
´´´
JAR output:
```bash
target/
```
---

📥 Installing the Addon

Place your final JAR into:
```bash
/plugins/EssentiaX/addons/
```
On the next server start, EssentiaX will automatically load:

✔ addon.yml
✔ your main class
✔ events
✔ all addon features

No plugin.yml needed at all.

---

🧪 Recommended Project Layout
```css
MyAddon/
 ├─ src/main/java/
 │   └─ your/package/MyAddon.java
 ├─ src/main/resources/
 │   └─ addon.yml
 ├─ build.gradle
 └─ settings.gradle
```
---

🤝 Contributing

EssentiaX API is open-source.
Issues and pull requests are welcome!

---

📜 License

EssentiaX API is open-source.
EssentiaX main plugin remains closed-source.

---

Created by **Mobilestars**