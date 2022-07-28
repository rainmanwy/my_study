package main

import (
	"fmt"
	"net/http"
	"os"
	"strings"
)

func main() {
	url := os.Args[1]
	if !strings.HasPrefix(url, "https://") {
		url = "https://" + url
	}
	resp, err := http.Get(url)
	if err != nil {
		fmt.Fprintln(os.Stderr, "Error: %v", err)
		os.Exit(1)
	}

	//content, err := ioutil.ReadAll(resp.Body)
	fmt.Println(resp.Status)
}
