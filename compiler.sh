#!/bin/bash
# Script de compilation pour Linux/macOS
# Usage : ./compiler.sh

cd "$(dirname "$0")/src" || exit 1
mkdir -p ../out
echo "Compilation en cours..."
find . -name "*.java" -print > sources.txt
javac -d ../out @sources.txt
status=$?
rm sources.txt
if [ $status -eq 0 ]; then
    echo "✓ Compilation réussie. Fichiers .class dans TP_Java/out"
    echo ""
    echo "Pour exécuter un test, par exemple :"
    echo "  cd out && java sn.uasz.m1.tp1.exo2.TestOperation"
else
    echo "✗ Compilation échouée."
fi
