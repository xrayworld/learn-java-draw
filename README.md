<h1 align="center">
$\Huge \substack{ 
\color{#FF5500}{\textsf{Java}} \\ 
\color{#555555}{\pmb{\texttt{Illustration with}}} \\ 
\color{#555555}{\texttt{System.out.println();}} 
}$
</h1>

<p align="center"> <img src="solidsnake.png" alt="Solid Snake APP Logo" width="555"> </p>

<h2 align="center">Steps</h2>
<p align="center">
  Inside <code>System.out.println()</code>, first goes the code 1, then, your text, then, the code 2.
</p>
<p align="center"><em>• code 1 (first):</em> <code>"\033[48;2;" + 0 + ";" + 0 + ";" + 0 + "m"</code></p>
<p align="center"><em>• code 2 (last):</em> <code>"\033[0m"</code></p>
<p align="center"><strong><code>System.out.println(     "\033[48;2;"+0+";"+0+";"+0+"m"     +" YOUR TEXT "+     "\033[0m"     );</code></strong></p>
<p align="center">
This prints one line of the graphic. As you see, you just need to modify the numbers <code>0</code> inside <code>+0+";"+0+";"+0+"</code>, which stand as RGB colors, the first <code>0</code> is for red colors, the next <code>0</code> is for green, and the third <code>0</code> is for blue.
</p>
<p align="center">
  <em>the "code 1" is which generates the color fill, the "code 2" is just a closure code, because without it, the fill will take all the width of the console. When you paint two or more colors, you only need to put this closure code once, at the end, due to the overwrite property of the "code 1" that paints above the last color. </em>
</p>

<h2 align="center">Example</h2>
<p align="center"> <img src="example1.png" alt="java programming about the console" width="333"> </p>
<p align="center">
The code is <code>System.out.println("\033[48;2;" + 255 + ";" + 255 + ";" + 0 + "m" + " 0123456789876543210 " + "\033[0m");</code>, this prints a large rectangle because is based in the quantity of characters inside.

For painting two colors, just put the "code 1" with a particular color, then, characters that shape its width, then, the "code 1" again with another color, then, another quantity of characters, and finally, the "code 2".
</p>
<p align="center"> <img src="example2.png" alt="java programming about the console" width="333"> </p>
<p align="center"><code>System.out.println("\033[48;2;" + 255 + ";" + 255 + ";" + 0 + "m" + "                    " + "\033[48;2;" + 0 + ";" + 255 + ";" + 255 + "m" + "       " + "\033[0m");</code>.</p>

<h2 align="center">Extra</h2>
<p align="center">
If you want to add color to the text itself instead of its background, replace the <code>48</code> in our "code 1" for <code>38</code>:
</p>
<p align="center"><em>• new code 1:</em> <code>"\033[38;2;" + 0 + ";" + 0 + ";" + 0 + "m"</code></p>
<p align="center">
In practice, you will notice the closure code finishes both, the background fill and the text color.
</p>
<p align="center"> <img src="example3.png" alt="java programming about the console" width="333"> </p>
<p align="center"><code>System.out.println("\033[38;2;" + 0 + ";" + 255 + ";" + 255 + "m" + " X-Ray World  " + "\033[0m");</code></p>
<h2 align="center"></h2>
<h1 align="center">www.x-ray.world</h1>
