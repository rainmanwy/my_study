package main

import (
	"fmt"
	"os"
)

func main() {
	for index, value := range os.Args {
		fmt.Printf("%03d: %v\n", index, value)
	}
}
