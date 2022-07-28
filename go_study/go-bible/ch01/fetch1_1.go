package main

import (
	"fmt"
	"io"
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

	//content, err := ioutil.ReadAll(resp.Body)
	io.Copy(os.Stdout, resp.Body)
	resp.Body.Close()
}
