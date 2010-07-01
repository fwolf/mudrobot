<?php
/**
 * Random select 1 line from tang300 and echo out.
 *
 * @package		mudrobot
 * @copyright   Copyright 2010, Fwolf
 * @author      Fwolf <fwolf.aide+mudrobot@gmail.com>
 * @since		2010-07-01
 */

$f = 'data/tang300.txt';	// This file is gbk encoding.
$s_shi = file_get_contents($f);
$f_encoding = 'gbk';

// Remove header comment, which is fixed length
$i = mb_strlen($s_shi, $f_encoding);
$s_shi = mb_substr($s_shi, 944, $i - 944, $f_encoding);

// Convert to array to treat by paragraph
$ar_shi = explode("\n\n", $s_shi);
foreach ($ar_shi as $k => $v) {
	if (empty($v))
		unset($ar_shi[$k]);

	// Title of shi, start with 3 digit.
	if (0 != intval(substr($v, 0, 3))) {
		// If title followed by 2 paragraph, the 1st is Xu, remove it.
		if (0 == intval(substr($ar_shi[$k + 2], 0, 3)))
			unset($ar_shi[$k + 1]);
		unset($ar_shi[$k]);
	}
}


/*
$s_shi = implode("\n", $ar_shi);
$s = $i . ' | ' . mb_substr($s_shi, 0, 10000, $f_encoding);
$s = mb_convert_encoding($s, 'utf-8', $f_encoding);
$s .= "\n";
echo $s;
*/


// All Shi's body paragraph are joined together, random select 1.
$s_shi = $ar_shi[array_rand($ar_shi)];
// Then random select 1 line in paragraph
$ar_shi = explode("\n", $s_shi);
$s = $ar_shi[array_rand($ar_shi)];

// Echo
/*
$s = mb_convert_encoding($s, 'utf-8', $f_encoding);
$s .= "\n";
*/
echo $s;

?>
