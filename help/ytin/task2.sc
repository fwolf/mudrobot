/al poisonact {/bell;halt;Quit}

/var {timeOvercmds} {5}
/al {overcmds} {l yao guai $nYaoguai}
/al Overcmds {/if {$overcmds=0}{/var overcmds 1;/purge;/ig 1;tick- F2;tick- tickft;/tickoff;/sleep $timeOvercmds;/var overcmds 0;/ig 0;upTime {overcmds;/tickon}}}
/act {你的眼前一黑} {tick- tickft;tick- F2;huti 0}
/act {你盘膝坐} {ctask}
/act {你现在真气不能凝聚，那能使用绝招} {eff +}
/al deadact /nop
/al aliveAct {set brief 3;tick+ bell 5;relogin}
/act {南城客栈} {/var place kz}
/act {安全区内不} {/if {[$place=kz]}{w;lsh 1;lastact}}
/al svFrd {/var done 1;get yao guai;Que {/loop {1,4}{get yao guai %0};upTime Que {/if {[$type=get]}{escfly endSeq};/if {[$type=quan]}{escfly {get yao from yao guai;get fen from yao guai;/if {[$WP=qinghong sword]}{get $WP from yao guai;dp sword 4}}};/if {[$type=kill]}{escfly {get yao from yao guai;get fen from yao guai;/if {[$WP=qinghong sword]}{get $WP from yao guai;dp sword 4};dp yao guai;kill yao guai;/al fdead fdead1;/al noppl fdead}}}}}
/act {你吃下一包金} {/nop laster can add to check if enuf 药 left}
/act {$frd慢慢睁开} {/if {[$type=quan]}{w;e;fight yao guai;Quan}}
/act {$frd死了。} {/var done 2;gc yao;gc fen;/if {[$WP=qinghong sword]}{gc $WP;dp sword 4};fdead}
/act {$frd神不守舍}{/var mihun 1;/sleep 30;/var mihun 0}
/act {「回风」要用} {/if {[$menpai=moon]}{time;enable dodge moondance;ext;enable dodge none}}
/act {你要对谁施展「舞雪」}{/if {[$menpai=moon]}{/var inext 0}}
/al fdead0 {/sleep 3;escfly endSeq}
/al fdead1 {/sleep 3;endSeq;/al fdead fdead0}
/al fdead fdead0
/act {这里禁止战斗。} {/if {0 && $difflvl<2 && [$type!=xiang]}{escfly endSeq} else {seq$nSeq;/math nSeq $nSeq+1;ft guai;aa}}
/act {这里没有 yao guai %0。}{escfly {/math first $first-1;/sleep 5;autotask}}
/act {你要对谁施展「空手入白刃」}{escfly {/math first $first-1;/sleep 5;autotask}}
/act {滚开，要不然我把你吃了。}{escfly {/math first $first-1;/sleep 5;autotask}}
/act {你想攻击谁？}{/if {$first=1}{escfly {/math first $first-1;/sleep 5;autotask}}}
/act {$frd走了过来}{/if {$doSeq && ($first=1 || $difflvl=10 || [$type=xiang])} {/var doSeq 0;Escfly {/math first $first-1;/sleep 5;autotask}}}
/var eatyao 1
/nop act {你要吃什么药？}{/if {$eatyao}{/var eatyao 0;escRecover;/sleep 5;/var eatyao 1}}
/act {无法集中} {/5 f4;f2;att3 1}

/act {$frd和你仇人} {/var WP xuanhua fu;hdGuai$menpai}
/act {$frd对你大喝} {/var WP xuanhua fu;hdGuai$menpai}
/act {$frd和你一碰面} {/var WP xuanhua fu;hdGuai$menpai}
/act {$frd喝道：你看招！} {/var WP xuanhua fu;hdGuai$menpai}
/act {$frd一见到} {/var WP xuanhua fu;hdGuai$menpai}
/act {$frd一眼瞥见} {/var WP xuanhua fu;hdGuai$menpai}

/act {你的法力提高了}{updata}
/al overcf3 updata
/al overcf2 updata
/al breakwp {/var mywpbroken 1;/if {[$menpai!=putuo] && [$menpai!=putuo] && [$menpai!=jjf]}{/var wp qinghong sword;remove shield;unwield $wpa;wld;wear all}}
/act {你现在有任务在身} {/sleep 3;zchan 2;chk {cancel;/if {$mywpbroken}{relogin} else {/if {$nei+30<$Nei*2 || $Nei/10>$forcea-1}{zchan 1} else {cf2 50;/al finishcf2 {/al finishcf2 /nop;/sleep 3;zchan 1}}}}}
/act {$_CYN$frd说道：你说得也有} {/var done 1;/sleep 3;escfly endSeq} {3}
/act {$_CYN$frd说道：这个。。。} {/if {[$type=quan]}{/var okquan 1}}{3}

/act {$_CYN$frd向后一纵}{/if {[$type=xiang]}{ht}}
/act {$_CYN$frd说道：我还没用尽}{/if {[$type=xiang] && $cancel=0}{/var win 1;/if {$nei*2>$Nei*3}{/sleep 3;/var doSeq 1;l} else {tick- tickft;tick- F2;/sleep 3;Que escfly {lsh 1;att3 1;Finisht chkJinchuang {/2 ctask;upTime cctask}}}}}{3}
/act {$_CYN$frd说道：打成平手}{/if {[$type=xiang] && $cancel=0 && ([$menpai!=wdd] || $first!=1)}{/if {$nei*2>$Nei*3}{/sleep 3;/var doSeq 1;l} else {tick- tickft;tick- F2;/sleep 3;Que escfly {lsh 1;att3 1;Finisht chkJinchuang {/2 ctask;upTime cctask}}}}}{3}
/act {$_CYN$frd说道：哈哈！你输}{/if {[$type=xiang] && $cancel=0 && ([$menpai!=wdd] || $first!=1)}{/if {$nei*2>$Nei*3}{/sleep 3;/var doSeq 1;l} else {tick- tickft;tick- F2;/sleep 3;Que escfly {lsh 1;att3 1;Finisht chkJinchuang {/2 ctask;upTime cctask}}}}}{3}
/act {$_CYN$frd说道：我受了伤} {give 1 $yao to yao guai $nYaoguai;fight yao guai $nYaoguai;aa} {3}
/act {$_CYN$frd说道：唉，真是}{tick- tickft;Que {/sleep 3;escfly endSeq}}{3}

/act {$_HIY突然间，天空中伸出一只大手把妖怪} {escRecover}
/var flyinft 1
/act {你正在战斗，飞不开。}{/if {$flyinft}{/var flyinft 0;flyinft;/sleep 3;/var flyinft 1}}
/al flyinft {/if {$done}{Que escfly endSeq} else {/if {$cancel}{cancelTask} else {Que Escfly {lsh 1;att3 1;Finisht chkJinchuang {/2 ctask;upTime cctask}}}}}

/al myyiyang {/if {$difflvl=1 && $QC_unarmed && $exp<20000000}{arm 0;/al abdact0 {/if {[$abdskill=扑击格斗之技]}{arm 1;/var QC_unarmed 0}}};/if {[$type=quan] && $fHurt2>=-40 && $okquan=0}{/sleep 1.5;quan yao guai} else {/if {[$type!=xiang] && 0 && (($difflvl>2 && $fHurt0>=40) || ($difflvl>1 && $fHurt0>=60) || ($difflvl=1 && $fHurt0>=100)) || [$type=quan]}{/sleep 1.5;/if {$done=0}{cst1}}}}

/nop HERE are actions for enemy pfms
/act {$frd把圆月心法}{/var ehuti huifeng;/if {$difflvl>0 && [$menpai!=moon]}{dd 0}}
/al wxAct {/if {[$menpai!=moon]}{eff 0};/var ehuti wx;/if {[$menpai=putuo]}{arm 2}}
/al nxAct {/math _clockEhuti $_clock;/if {[$type=xiang]}{surrender} else {escRecover;eff 0};/var ehuti nx}
/al nxdone {/var ehuti 0;/if {[$type=kill] || $fHurt0<=-10 || $fHurt0>=10 || {[$menpai!=putuo]}}{eff +}}

/act {「大海无量」需要以龙神身法} {enable dodge $klDodge;perform dhwl;enable dodge none}
/act {你正在使用内功的其他} {/if {[$menpai=wdd] && [$inext!=0]}{remove shield;wield $wp;wear all;ext;unwield $wp}}
/act {不料你蓦地收回双指} {/if {$doDuo}{/var doDuo 0;huti 0;Que {dp $WP;remove shield;wld;wear shield;upTime escRecover}}}

/act {$frd同时使出风回} {/if {($difflvl>5 || [$menpai!=putuo]) && [$type=xiang]}{cancelTask} else {f2;/if {[$menpai!=jjf]}{/5 eat $yao;dd 0}}}
/act {$frd一声龙吟，热气} {f2;/if {[$menpai!=jjf]}{/5 eat $yao}}
/act {$frd反手一掌向} {f2;/if {[$menpai!=jjf]}{/5 eat $yao};/if {([$menpai=putuo] || [$menpai=lg]) && $difflvl>0}{arm 0}}
/act {$frd双手划一} {/if {$difflvl>0}{f2;/if {0 && [$type=xiang]}{cancelTask}};/if {[$menpai!=jjf]}{/5 eat $yao};f2}
/act {$_HIY$frd长鞭抖动} {/if {$difflvl>5 || [$menpai!=putuo]}{cancelTask}}
/act {^$frd运足精神，身形} {/if {$difflvl>5}{cancelTask}}
/act {^$frd运足精神，一个高跳} {/if {$difflvl>5}{cancelTask}}
/act {$frd把混天气功在体内运行一周，只觉浑身杀起腾腾，看谁都不顺眼。}{/nop}
/act {$_HIG$frd运气镇元神功}{/if {$difflvl>5 || ($difflvl>5 && [$type=xiang])}{cancelTask}}
/act {$_HIC$frd运起镇元神功}{/if {$difflvl>5 || ($difflvl>5 && ([$type=xiang] || [$menpai!=putuo]))}{cancelTask}};/nop jianzhang
/act {$_HIW$frd猛然运起冰谷}{/if {$difflvl>5}{cancelTask}}
/act {$frd的招式出到一半，脚下突然一个踉跄}{/nop if {$fHurt0>10 || [$type=kill]}{eff +};/if {$difflvl>5}{cancelTask}}
/act {$frd把全身劲力运于双掌}{/if {$difflvl>5}{cancelTask} else {/nop eff +}}
/act {$frd伸出右手食指} {/if {[$menpai=putuo] && $difflvl<6}{tick+ F2 1} else {cancelTask}}
/act {$frd口中念念有词} {/var ldlh 1;cancelTask}
/act {$_HIC$frd剑尖一挑，轻飘飘地指向你} {cancelTask}

/act {m东方的} {/math tmp $nSeq-1;/var outdoor$tmp 1;/var OUTDOOR 1;showtask}
/act {m太阳} {/math tmp $nSeq-1;/var outdoor$tmp 1;/var OUTDOOR 1;showtask}
/act {m现在是正午} {/math tmp $nSeq-1;/var outdoor$tmp 1;/var OUTDOOR 1;showtask}
/act {m一轮火红} {/math tmp $nSeq-1;/var outdoor$tmp 1;/var OUTDOOR 1;showtask}
/act {m夜晚降临了} {/math tmp $nSeq-1;/var outdoor$tmp 1;/var OUTDOOR 1;showtask}
/act {m夜幕} {/math tmp $nSeq-1;/var outdoor$tmp 1;/var OUTDOOR 1;showtask}
