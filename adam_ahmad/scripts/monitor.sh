#!/bin/bash

# Default to localhost
APP_URL="http://localhost:8080/adam_ahmad/"

# Optional: override with ngrok URL if provided
if [ -f ngrok_url.txt ] && [ -s ngrok_url.txt ]; then
  echo "Using public URL from ngrok_url.txt"
  APP_URL="$(cat ngrok_url.txt)"
fi

# Perform simple check
echo "Pinging: $APP_URL"
curl -s "$APP_URL" > /dev/null

if [ $? -eq 0 ]; then
  echo "✅ Web App is UP!"
else
  echo "❌ Web App is DOWN!"
  exit 1
fi
