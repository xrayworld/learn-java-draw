<div align="center">
  <img src="banner.svg" alt="Animated banner — Java Terminal Pixel Art" width="100%"/>
</div>

<br/>

<div align="center">

# Java illustration

*"Hecho por www.x-ray.world"*

<br/>

<p align="center">
  <img src="solidsnake.png" alt="Solid Snake — Java Terminal Pixel Art" width="420"/>
</p>

<p align="center">
  <em>Pixel art rendered entirely inside a Java console — no graphics library, no framework, just <code>System.out.println()</code> and RGB numbers.</em>
</p>

---

## Table of Contents

- [What is this?](#-what-is-this)
- [The Anatomy of the Code](#-the-anatomy-of-the-code)
- [Step-by-step Tutorial](#-step-by-step-tutorial)
- [Background vs Text Color](#-background-vs-text-color)
- [Color Reference Table](#-color-reference-table)
- [Gallery](#-gallery)
- [Repository Structure](#-repository-structure)
- [The Full Source](#-the-full-source)
- [About](#-about)

---

## 🎯 What is this?

This repository shows how to paint **pixel art directly in the Java console** using **ANSI escape codes** embedded inside `System.out.println()`. Every colored rectangle you see is made from plain text characters with an RGB color code prepended to them.

No external library. No image file. Just Java's standard output — and the full 16 million colors of the RGB spectrum.

---

## 🔬 The Anatomy of the Code

Every colored line follows this pattern:

```
"\033[48;2;" + R + ";" + G + ";" + B + "m"  +  YOUR TEXT  +  "\033[0m"
```

| Fragment | Role |
|---|---|
| `\033[` | ESC character — starts the ANSI sequence |
| `48;2;` | Select **background** color in true-color (24-bit) mode |
| `R;G;B` | Red, Green, Blue values — each from `0` to `255` |
| `m` | Closes the escape sequence |
| `YOUR TEXT` | Any characters — their quantity defines the block **width** |
| `\033[0m` | **Reset** — stops the color fill |

> The width of the colored block is determined by how many characters you place inside. Spaces work perfectly — `"          "` (10 spaces) = a 10-character-wide rectangle.

---

## 📐 Step-by-step Tutorial

### Step 1 — One color, one line

```java
String colorOn  = "\033[48;2;" + 255 + ";" + 255 + ";" + 0 + "m";
String colorOff = "\033[0m";

System.out.println( colorOn + " 0123456789876543210 " + colorOff );
```

<p align="center">
  <img src="example1.png" alt="Example 1 — single yellow block" width="380"/>
</p>

The three numbers `255`, `255`, `0` are the **R**, **G**, **B** components. Change them to change the color.

---

### Step 2 — Two colors on the same line

Just stack multiple color blocks before the final reset:

```java
String yellow = "\033[48;2;255;255;0m";
String cyan   = "\033[48;2;0;255;255m";
String reset  = "\033[0m";

System.out.println( yellow + "                    " + cyan + "       " + reset );
```

<p align="center">
  <img src="example2.png" alt="Example 2 — yellow and cyan blocks" width="380"/>
</p>

> You only need **one** reset at the very end. Each new color block automatically overwrites the previous one.

---

### Step 3 — Color the text itself

Swap `48` → `38` to colorize the **foreground** (the characters) instead of the background:

```java
String textColor = "\033[38;2;" + 0 + ";" + 255 + ";" + 255 + "m";
String reset     = "\033[0m";

System.out.println( textColor + " X-Ray World " + reset );
```

<p align="center">
  <img src="example3.png" alt="Example 3 — colored text" width="380"/>
</p>

---

### Putting it all together

Combine dozens of `println()` calls — each one paints a horizontal strip. Stack them vertically to build pixel art:

```java
String green = "\033[48;2;102;204;153m";
String dark  = "\033[48;2;51;153;102m";
String red   = "\033[48;2;255;102;102m";
String reset = "\033[0m";

System.out.println( dark  + "  " + green + "          " + dark + "  " + reset );
System.out.println( green + "                      "                  + reset );
System.out.println( green + "         " + red + "   " + green + "    "+ reset );
```

---

## 🎨 Background vs Text Color

| Mode | Code | Effect |
|---|---|---|
| **Background** | `\033[48;2;R;G;Bm` | Fills the cell behind characters |
| **Foreground** | `\033[38;2;R;G;Bm` | Colors the characters themselves |
| **Reset** | `\033[0m` | Clears both background and foreground |

You can mix both in a single `println()`:

```java
String bg   = "\033[48;2;20;20;20m";   // near-black background
String fg   = "\033[38;2;102;204;153m"; // green text
String reset= "\033[0m";

System.out.println( bg + fg + "  SOLID SNAKE  " + reset );
```

---

## 🌈 Color Reference Table

Some handy RGB values to get started:

| Color | R | G | B | Preview |
|---|---|---|---|---|
| Red | 255 | 0 | 0 | `\033[48;2;255;0;0m` |
| Orange | 255 | 140 | 0 | `\033[48;2;255;140;0m` |
| Yellow | 255 | 255 | 0 | `\033[48;2;255;255;0m` |
| Lime | 50 | 255 | 50 | `\033[48;2;50;255;50m` |
| Cyan | 0 | 255 | 255 | `\033[48;2;0;255;255m` |
| Blue | 50 | 140 | 255 | `\033[48;2;50;140;255m` |
| Purple | 160 | 50 | 255 | `\033[48;2;160;50;255m` |
| Magenta | 255 | 50 | 180 | `\033[48;2;255;50;180m` |
| White | 255 | 255 | 255 | `\033[48;2;255;255;255m` |
| Black | 0 | 0 | 0 | `\033[48;2;0;0;0m` |

> Any RGB value between `0`–`255` is valid — that's over **16 million** possible colors.

---

## 🖼️ Gallery

<table>
  <tr>
    <td align="center"><img src="example1.png" width="260" alt="Example 1"/><br/><sub>Single background block</sub></td>
    <td align="center"><img src="example2.png" width="260" alt="Example 2"/><br/><sub>Two colors on one line</sub></td>
    <td align="center"><img src="example3.png" width="260" alt="Example 3"/><br/><sub>Foreground text color</sub></td>
  </tr>
  <tr>
    <td colspan="3" align="center">
      <img src="solidsnake.png" width="340" alt="Solid Snake — full pixel art output"/>
      <br/><sub>Complete pixel art — built entirely from <code>System.out.println()</code></sub>
    </td>
  </tr>
</table>

---

## 📁 Repository Structure

```
📦 java-terminal-pixel-art
 ┣ 📄 solidsnake.java          ← Full Solid Snake pixel art source
 ┣ 🖼️  solidsnake.png           ← Screenshot of the console output
 ┣ 🖼️  example1.png             ← Screenshot — single color block
 ┣ 🖼️  example2.png             ← Screenshot — two color blocks
 ┣ 🖼️  example3.png             ← Screenshot — colored text
 ┣ 🎞️  banner.svg               ← Animated banner (this page's header)
 ┗ 📁 src/
    ┗ 📁 examples/
       ┣ 📄 BackgroundColor.java  ← Example 1 as standalone file
       ┣ 📄 TwoColors.java        ← Example 2 as standalone file
       ┗ 📄 TextColor.java        ← Example 3 as standalone file
```

---

## 💻 The Full Source

<details>
<summary><strong>Click to expand — solidsnake.java</strong></summary>

```java
// ⁙ PRIVATE LICENSE owned by WWW.X-RAY.WORLD
// © COPYRIGHT by X-Ray World Corporation
public class Main {
    public static String s0(int r, int g, int b) {
        return String.format("\033[48;2;%d;%d;%dm", r, g, b);
    }
    public static String s1(int r, int g, int b) {
        return String.format("\033[38;2;%d;%d;%dm", r, g, b);
    }

    public static final String s9      = "\033[0m";
    public static final String s01logo = s0(102, 204, 153);
    public static final String s02logo = s0(51, 153, 102);
    public static final String s011logo= s0(255, 102, 102);
    public static final String s022logo= s0(204, 51, 51);
    public static final String s11logo = s1(102, 204, 153);
    public static final String s12logo = s1(51, 153, 102);

    public static void p(String text) { System.out.println(text); }

    public static void main(String[] args) {
        p(s1(204,255,255)+"▍▔▔▔  ▍▔▔▍  ▍    ▍  ▍▔▘▖ "+s9);
        p(s1(153,255,204)+"▔▔▔▍  ▍  ▍  ▍    ▍  ▍ ▖▘ "+s9);
        p(s1(102,204,153)+"▔▔▔   ▔▔▔   ▔▔▔     ▔▔   "+s9);
        p(s1(255,204,204)+"▍▔▔▔  ▍▖ ▍  ▍▔▔▍  ▍ ▖▘  ▍▔▔  "+s9);
        p(s1(255,153,153)+"▔▔▔▍  ▍ ▘▍  ▍  ▍  ▍▔▘▖  ▍▔▔  "+s9);
        p(s1(255,102,102)+"▔▔▔                     ▔▔▔  "+s9);
        p("");
        p(s12logo+"       ▂▂▂       ▂▂▂        ");
        p(s12logo+"      ▟"+s01logo+"            ▟ "+s9+s11logo+"▙"+s9);
        p(s12logo+"     "+s02logo+" "+s01logo+"            ▟"+s0(0,0,0)+" "+s02logo+" "+s01logo+"   "+s02logo+" "+s9+s12logo+"▙"+s9);
        p(s12logo+"    ▟"+s01logo+"▔▔          ▔▔▔  "+s02logo+"    "+s9);
        p(s12logo+"  ▟"+s01logo+"                 "+s02logo+">    "+s9+s12logo+"▛"+s9);
        p(s12logo+"▟"+s01logo+"             "+s02logo+"          "+s9+s12logo+"▛"+s9);
        p(s12logo+"▜"+s01logo+"           "+s02logo+"   "+s022logo+"     "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s12logo+"  ▜"+s01logo+"      "+s02logo+"    "+s022logo+"   "+s011logo+"  "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+s1(255,255,255)+"    🙽 🙽   "+s022logo+"   "+s011logo+"  "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+"           "+s022logo+" "+s011logo+"   "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+"        "+s12logo+"▟"+s011logo+"    "+s02logo+"  "+s9+s12logo+"▛"+s9);
        p(s11logo+"       "+s02logo+"       "+s9+s12logo+"▛"+s9);
    }
}
```

</details>

### Quick run

```bash
# Compile
javac solidsnake.java

# Run
java Main
```

> Make sure your terminal supports **true-color** (24-bit) ANSI codes. Most modern terminals do — VS Code integrated terminal, iTerm2, Windows Terminal, GNOME Terminal, etc.

---

## 🌐 About

Created by **[X-Ray World](https://www.x-ray.world/)** — a creative studio exploring the edges of code, art, and design.

<div align="center">
  <br/>
  <a href="https://www.x-ray.world/">
    <img src="https://img.shields.io/badge/www.x--ray.world-FF5500?style=for-the-badge&logoColor=white" alt="x-ray.world"/>
  </a>
  <br/><br/>
  <sub>© X-Ray World Corporation · All rights reserved</sub>
</div>
