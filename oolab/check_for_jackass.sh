#!/bin/bash
# Decode the base64 text and search for 'jackass'
decoded_text=$(openssl enc -base64 -A -d < home-screen-text.txt)
echo "$decoded_text" | grep -q 'jackass'
if [ $? -eq 0 ]; then
    exit 1  # Found 'jackass', this is a bad commit
else
    exit 0  # Did not find 'jackass', this is a good commit
fi
