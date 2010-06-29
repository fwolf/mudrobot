/nop high {brown} {[%0]}
/al {kfAct} {/al kfact %0;/act {汴京铁塔}{kfact;/al kfact kfact0}}
/al kfact0 /nop

/var {overcmds} {0}
/var {timeOvercmds} {15}
/al {overcmds} {/nop}
/act {你一次输入} {Overcmds}
/al Overcmds {/if {$overcmds=0}{/var overcmds 1;/purge;/tickoff;/sleep $timeOvercmds;;/var overcmds 0;upTime {overcmds;/tickon}}}
/var noExpPr 0
/al noExpPr /nop
/act {你的道行还不够} {/if {$noExpPr=0}{/var noExpPr 1;noExpPr;/sleep 5;/var noExpPr 0}}

/act {你打了个寒颤} {poisonact};/al poisonact /bell
/act {$_HIG$你感觉身体一点点} {poisonact}

/act {$frd一咬牙，把凝血} {nxAct};/al nxAct /bell
/act {$frd凝血功逆行一周天完毕} {nxdone};/al nxdone /bell
/act {$frd把凝血神功在体内运转，然后徐徐注入冰刀中} {nxAct2};/al nxAct2 /bell
/act {$frd把小无相功在体内运行} {wxAct} {6};/al wxAct /nop
/act {你把小无相功在体内运行} {mywxact};/al mywxact {/var inext jldl}
/act {你的小无相功运行} {mywxdone};/al mywxdone /nop
/act {你被攻了个措手不及，伤势} {3axeAct};/al 3axeAct /bell
/act {你微一凝神，运起反五行}{/var clockhuti $_clock;/var inext powerup;mytonact};/al mytonact /nop
/act {你的反五行摄气诀运行一周} {/var inext 0;mytondone};/al mytondone /nop
/act {你把混天气功在体内} {myzxact};/al myzxact {/var inext zhuxie}
/act {你的混天气功运行一周} {myzxdone;/var inext 0};/al myzxdone /nop
/act {你把圆月心法在体内} {myhfact};/al myhfact {/var inext huifeng}
/act {你的圆月心法运行一周} {myhfdone;/var inext 0};/al myhfdone /nop
/var inext 0
/act {你把莲台心法} {/var clockhuti $_clock;/var inext huti;mylotact};/al mylotact /nop
/act {你的莲台心法运行} {/var inext 0;mylotdone};/al mylotdone /nop
/act {微一凝神，运起龙神心法} {/var clockshield $_clock;/var inext shield;myshldact};/al myshldact /nop
/act {你的龙神心法运行} {/var inext 0;myshlddone};/al myshlddone /nop
/act {你把内功心法在心中默念} {/var dhwl 1}
/act {你一声龙吟，热气} {/var dhwl 2;/sleep 8;/var dhwl 0;/if {!$que} {ef 0;perform dhwl}}
/act {你用尽全力，一个旋身}{/var ssj 1;/sleep 5;/var ssj 0}
/act {你趁%0正得意} {/var ssj 1;/sleep 7;/var ssj 0}
/act {你的指力正} {myyiyang};/al myyiyang /nop
/act {你双手划一大圆} {my3};/al my3 /nop
/act {看来该找机会} {time2esc};/al time2esc /nop

/act {你奋力望上一跳} {failfly};/al {failfly} {/nop}
/act {你现在头脑不太} {failfly}
/act {你想飞起来} {2ht2fly};/al 2ht2fly failfly
/math nocloud 0
/act {周围没有一片云} {/if {$nocloud=0}{nocloud};/math nocloud 1;/sleep 0.4;/math nocloud 0};/al {nocloud} {/nop}
/act {已经被喝得} {/if {$dk<$Dk-30} {/var water 0;fillact}};/al fillact /nop
/act {这里不准念咒文} {nocast};/al {nocast} {/nop}

/act {你改用另一种法术} {ecc}
/act {你现在的气} {noqi};/al {noqi} {wakeact}
/act {你现在精神太差} {nosh};/al {nosh} {wakeact}
/act {你行功完毕} {finishcf2};/al {finishcf2} {/nop }
/act {你冥想完毕} {finishcf3};/al {finishcf3} {/nop}
/act {当你的法力} {overcf3};/al overcf3 /nop
/act {当你的内息} {overcf2};/al overcf2 /nop
/act {你缓缓睁开} {finishxd};/al {finishxd} {/nop}
/act {你深深地吐} {/if {$tickon_quitact} {/nop} else {/if {$killing}{/nop} else {finishqjn}}};/al finishqjn /nop

/act {你要看什么} {lWhat};/al lWhat /nop
/act {你的钱不够} {nomoney};/al nomoney /nop
/act {你要跟谁买} {bFromWhom};/al bFromWhom /nop
/act {对你而言太重了} {2heavy4u};/al 2heavy4u /nop
/act {而言太重了} {2heavy} {6};/al 2heavy /nop
/act {你目前所%0的技能} {urskill};/al urskill /nop
/act {这里没有这个人} {noppl};/al noppl /nop
/act {你想攻击谁} {attWhom};/al attWhom /nop
/act {你要向谁求教} {lnWhom};/al lnWhom /nop
/act {你要读什么} {stWhat};/al {stWhat} {/var fighting 0}
/act {你无法在战斗中} {fighting};/al {fighting} {/var fighting 1}
