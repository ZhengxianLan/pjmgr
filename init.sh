#!/bin/bash
# 更新包列表并安装 Dante SOCKS5 服务器
apt-get update -y
apt-get install dante-server -y

# 动态获取网卡接口名称
NET_IF=$(ip -o -4 route show to default | awk '{print $5}')

# 创建用于 SOCKS5 认证的用户并设置密码
SOCKS5_USER="libai"
SOCKS5_PASS="dufu"

# 创建用户
useradd $SOCKS5_USER
echo "$SOCKS5_USER:$SOCKS5_PASS" | chpasswd

# 写入 danted 配置文件
cat <<EOL > /etc/danted.conf
logoutput: syslog

internal: $NET_IF port = 1080
external: $NET_IF

method: username
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
