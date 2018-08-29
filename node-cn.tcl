set ns [new Simulator]
set nf [open o.nam w]
$ns namtrace-all $nf
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]
set n7 [$ns node]
set n8 [$ns node]
$ns duplex-link $n0 $n1 2Mb 10ms DropTail
$ns duplex-link $n1 $n2 2Mb 10ms RED
$ns duplex-link $n2 $n3 1.7Mb 20ms RED
$ns duplex-link $n3 $n4 2Mb 10ms RED
$ns duplex-link $n4 $n5 2Mb 10ms RED
$ns duplex-link $n5 $n6 2Mb 5ms DropTail
$ns duplex-link $n6 $n7 2Mb 10ms RED
$ns duplex-link $n7 $n8 2Mb 15ms DropTail
$ns duplex-link $n8 $n0 2Mb 5ms DropTail
proc finish {} {
        global ns nf
        $ns flush-trace
        close $nf
        exec nam o.nam &
        exit 0
}
set tcp0 [new Agent/TCP]
$tcp0 set class_ 2
$ns attach-agent $n0 $tcp0
set sink [new Agent/TCPSink]
$ns attach-agent $n3 $sink
$tcp0 set fid_ 1

set udp [new Agent/UDP]
$ns attach-agent $n1 $udp
set null [new Agent/Null]
$ns attach-agent $n3 $null
$ns connect $udp $null
$udp set fid_ 2

$ns at 1.0 "finish"
$ns run
