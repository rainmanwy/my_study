package main

import (
	"fmt"
	"os"
)

func main() {
	var s, sep string
	for index := 1; index < len(os.Args); index++ {
		s += sep + os.Args[index]
		sep = ";"
	}
	fmt.Println(s)
}
