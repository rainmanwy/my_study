package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	wordsCount := make(map[string]int)

	file := "dup2.txt"
	f, err := os.Open(file)
	if err != nil {
		fmt.Fprintf(os.Stderr, "dup2: %v\n", err)
		return
	}

	countLines(f, wordsCount)
	for line, count := range wordsCount {
		fmt.Printf("%v: %d\n", line, count)
	}

}

func countLines(f *os.File, counts map[string]int) {
	input := bufio.NewScanner(f)
	for input.Scan() {
		counts[input.Text()]++
	}
}
