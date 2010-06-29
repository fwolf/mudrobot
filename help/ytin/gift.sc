/killall
/message var 0
/var chname 核桃
/var name testnut
/var sex m
/var passwd 00000
/var yesa 0
/var yesb 0
/var BL 9
/var DS 9
/var WX 28
/var LX 15
/var DL 11
/var RM 9
/var GG 15
/var FY 28
/ac {膂力：[%0]%1胆识：[%2]%3悟性：[%4]%5灵性：[%6]} {/math bl %0;/math ds %2;/math wx %4;/math lx %6;chk1} {2}
/ac {定力：[%0]%1容貌：[%2]%3根骨：[%4]%5福缘：[%6]} {/math dl %0;/math rm %2;/math gg %4;/math fy %6;chk2} {2}
/al chk1 {/showme $bl $ds $wx $lx;/if {$bl>$BL && $ds>$DS && $wx=29 && $lx>$LX} {/var yesa 1}}
/al chk2 {/showme $dl $rm $gg $fy;/if {$dl>28 && $rm>$RM && $gg>$GG && $fy>$FY} {/var yesb 1}}

/var idle 0
/tickon
/ticksize 10
/act {^#TICK!!!} {/if {$idle=1} {/cr};/math idle 1}
/ac {您同意这组天赋数值吗？[n|y|q]} {/var idle 0;/if {($yesa=1)&&($yesb=1)} {y;/cr;/bell;beforequit;quit;quit};/var yesa 0;/var yesb 0;n}}
/al beforequit {/all /ig}

/ac {你发现事情不大对了，但是又说不上来。} {/z}
/ac {您的英文名字：} {$name}
/act {请输入相应密码：} {$passwd;$chname;$passwd;$passwd;;$sex}
/ac {人物，您确定吗(y/n)？} {y;$chname;$passwd;$passwd;;$sex}
/alias {xyj} {/ses {%%0} {202.105.177.101 6666}}
/al aa {/loop {1,3} {xyj a%0;/nop snoop a%0}}
/ses ox {0 0};/ox /tickon;/ox /ticksize 10;/ox /act {^#TICK!!!} {aa}
aa;/a1
