package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	wordsCount := make(map[string]int)

	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		wordsCount[input.Text()]++
	}

	for line, count := range wordsCount {
		fmt.Printf("%v: %d\n", line, count)
	}

}
