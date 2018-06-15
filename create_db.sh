#!/usr/bin/env bash
sudo -u postgres createuser -P payments
sudo -u postgres createdb -O payments payments
sudo -u postgres createuser -P payments_test
sudo -u postgres createdb -O payments_test payments_test
