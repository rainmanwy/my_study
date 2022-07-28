package main

import (
	"fmt"
	"strings"
	"time"
)

func main() {

	beginT := time.Now()
	total, sub := "", "test"
	for i := 0; i < 10000; i++ {
		total += sub
	}
	fmt.Println(time.Now().Sub(beginT).Seconds())

	beginT2 := time.Now()
	subs := []string{}
	for i := 0; i < 10000; i++ {
		subs = append(subs, sub)
	}
	strings.Join(subs, "")
	fmt.Println(time.Now().Sub(beginT2).Seconds())
}
