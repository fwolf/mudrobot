/act {ÆøÑª%1m%2/%3%4(%5%)%6ÄÚÁ¦£º%7m%8/%9(} {/math qix %2;/math Qix %3;/math perQix %5;/math nei %8;/math Nei %9} {3}
/act {¾«Éñ%0m%1/%2%3(%4%)%5·¨Á¦£º%6m%7/%8(+%9)} {/math shen %1;/math Shen %2;/math perShen %4;/math fa %7;/math Fa %8;/math enchant %9} {3}
/var lag 0
/act {Ê³Îï%1m%2/%3%4Ç±ÄÜ%5m%6} {/math fd %2;/math Fd %3;/math pot %6;/var lag 0} {3}
/act {É±    Æø£º $_RED%0}{/math shaqi %0}
/ac {ëöÁ¦£º[%0]%1µ¨Ê¶£º[%2]%3ÎòÐÔ£º[%4]%5ÁéÐÔ£º[%6m%7]} {/math spi %7}

/nop /al stats {/var qix;/var Qix;/var shen;/var Shen;/var nei;/var Nei;/var fa;/var Fa;/var fd;/var Fd;/var dk;/var Dk;/var pot}

/var check 0
/al chk {hp;/al lastact hp;/math check 1;/al actCheck %0}
/al chkexp /nop
/al chkexp0 {/if {$enchant<($Fa/20+1)}{/math enchant $Fa/20+1;enchant $enchant}}
/act {ÒûË®%1m%2/%3%4µÀÐÐ} {/math dk %2;/math Dk %3;/math exp 0;/if {$check=1}{calc;/math check 0;actCheck} } {3}
/act {ÒûË®%1m%2/%3%4µÀÐÐ%5m%6Äê%7Ìì} {/math dk %2;/math Dk %3;/ctoi tmpYear %6;/ctoi tmpDay %7;/math exp {$tmpYear*1000+$tmpDay*4};/if {$check=1}{chkexp0;chkexp;calc;/math check 0;actCheck} } {1}
/act {ÒûË®%1m%2/%3%4µÀÐÐ%5m%6Äê} {/math dk %2;/math Dk %3;/ctoi tmpYear %6;/math exp {$tmpYear*1000};/if {$check=1}{chkexp0;chkexp;calc;/math check 0;actCheck} } {2}
/act {ÒûË®%1m%2/%3%4µÀÐÐ%5m%6Ìì} {/math dk %2;/math Dk %3;/ctoi tmpDay %6;/math exp {$tmpDay*4};/if {$check=1}{chkexp0;chkexp;calc;/math check 0;actCheck} } {2}
/al nei2x {/math %1 {(%%2)*$forcea/50}};/nop jin/qix/shen the nei can recover, x=nei*forcea/50
/al nei4x {/math %1 {(%%2)*50/$forcea}};/nop nei required to recover jin/qix/shen, nei=x*50/forcea
/al qi4nei {/math %1 {(%%2)*30/($forcea/10+$tizi/2+24)}};/nop qi required to exercise to nei, 24 is for random(25)
/al qi4Nei {/math tmpQi {(%%2+1)*30/($forcea/10+$tizi/2)};/if {$tmpQi>10}{/math %%1 $tmpQi} else {/math %%1 10}};/nop qi required to exercise to over exercise nei, 24 is for random(25)
/nop al sh4fa {/math %1 {(%%2)*30/($spella/10+$spi)} }
/al sh4fa {/math tmpsh0 {(%%2)*30/($spella/10+$spi)};/loop {1,10} {/if {$tmpsh0*($spella/10+$spi)/30>%%%2}{/math tmpsh0 $tmpsh0-1}};/math %1 $tmpsh0}
/al sh4Fa {/math tmpSh {1+(%%2+1)*30/($spella/10+$spi)};/loop {1,10} {/if {$tmpSh*($spella/10+$spi)/30<(%%%2+2)}{/math tmpSh $tmpSh+1}};/if {$tmpSh>10}{/math %%1 $tmpSh} else {/math %%1 10}}
/al calc {qi4nei qi $Nei*2-$nei;qi4Nei Qi $Nei*2-$nei;sh4fa sh $Fa*2-$fa;sh4Fa Sh $Fa*2-$fa;nei4x neiqi $Qix-$qix;nei4x neish $Shen-$shen}
