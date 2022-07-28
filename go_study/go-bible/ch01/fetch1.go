package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
)

func main() {
	url := os.Args[1]
	resp, err := http.Get(url)
	if err != nil {
		fmt.Fprintln(os.Stderr, "Error: %v", err)
		os.Exit(1)
	}

	content, err := ioutil.ReadAll(resp.Body)
	resp.Body.Close()
	if err != nil {
		fmt.Fprintln(os.Stderr, "Error: %v", err)
		os.Exit(1)
	}

	fmt.Printf("Content: %s\n", content)
}
