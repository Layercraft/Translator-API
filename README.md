[![](https://jitpack.io/v/Layercraft/PacketLib.svg)](https://jitpack.io/#Layercraft/PacketLib)
[![Java CI with Gradle](https://github.com/Layercraft/PacketLib/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/Layercraft/PacketLib/actions/workflows/gradle-build.yml)
[![Gradle Publish](https://github.com/Layercraft/PacketLib/actions/workflows/gradle-publish.yml/badge.svg)](https://github.com/Layercraft/PacketLib/actions/workflows/gradle-publish.yml)
[![Deploy Dokka KDocs with GitHub Pages](https://github.com/Layercraft/PacketLib/actions/workflows/kdocs.yml/badge.svg)](https://github.com/Layercraft/PacketLib/actions/workflows/kdocs.yml)

# PacketLib - A library for creating and parsing packets

## Warning: Not safe for use currently.

KDocs: [PacketLib KDocs](https://packetlib.kdocs.layercraft.io/)

## Prewords

Special Thanks to [wiki.vg](https://wiki.vg) for the protocol documentation.
And to [PrismarineJS/minecraft-data](https://github.com/PrismarineJS/minecraft-data) for the protocol data as json.

## Repo

### Github Packages:

<details open>
<summary>Gradle Kotlin</summary>

```kotlin
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/Layercraft/Translator-API")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation("io.layercraft.connector:translator-api:0.0.23")
}
```

</details>


<details>
<summary>Gradle Groovy</summary>

```groovy
repositories {
    maven {
        url = 'https://maven.pkg.github.com/Layercraft/Translator-API'
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    compile 'io.layercraft.connector:translator-api:0.0.23'
}
```

</details>

<details>
<summary>Maven</summary>

```xml

<project>
    ...
    <repositories>
        <repository>
            <id>Translator-API</id>
            <url>https://maven.pkg.github.com/Layercraft/Translator-API</url>
        </repository>
    </repositories>
    ...
    <dependencies>
        <dependency>
            <groupId>io.layercraft.connector</groupId>
            <artifactId>translator-api</artifactId>
            <version>0.0.23</version>
        </dependency>
    </dependencies>
    ...
</project>
```

Settings.xml

```xml

<settings>
    ...
    <servers>
        <server>
            <id>Translator-API</id>
            <username>USERNAME</username>
            <password>TOKEN</password>
        </server>
    </servers>
    ...
</settings>
```

</details>

### Jitpack:

<details open>
<summary>Gradle Kotlin</summary>

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.layercraft:packetlib:0.0.23")
}
```

</details>

<details>
<summary>Gradle Groovy</summary>

```groovy
repositories {
    maven { url = 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.layercraft:packetlib:0.0.23'
}
```

</details>

<details>
<summary>Maven</summary>

```xml

<project>
    ...
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    ...
    <dependencies>
        <dependency>
            <groupId>com.github.layercraft</groupId>
            <artifactId>packetlib</artifactId>
            <version>0.0.23</version>
        </dependency>
    </dependencies>
    ...
</project>
```

</details>

## Usage

Serialize a packet to a byte array:

```kotlin
val packet = SetProtocolPacket(ProtocolVersion.V1_19_2.protocolNumber, "localhost", 25565, 1)

val bytes = TranslatorAPI.encodeToByteArray(packet, SetProtocolPacket)
```

Deserialize a packet from a byte array:

```kotlin
val packet = TranslatorAPI.decodeFromByteArray(bytes, SetProtocolPacket)
```
