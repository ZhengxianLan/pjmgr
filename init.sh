#!/bin/bash
# 更新包列表并安装 Dante SOCKS5 服务器
apt-get update -y
apt-get install dante-server -y

# 动态获取网卡接口名称
NET_IF=$(ip -o -4 route show to default | awk '{print $5}')

# 写入 danted 配置文件
cat <<EOL > /etc/danted.conf
logoutput: syslog

internal: $NET_IF port = 1080
external: $NET_IF

method: username none
user.privileged: proxy
user.notprivileged: nobody

client pass {
   from: 0.0.0.0/0 to: 0.0.0.0/0
   log: error
}

pass {
   from: 0.0.0.0/0 to: 0.0.0.0/0
   protocol: tcp udp
}
EOL

# 重启 danted 服务
systemctl restart danted
systemctl enable danted
