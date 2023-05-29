package org.example;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.resolver.dns.DnsNameResolver;
import io.netty.resolver.dns.DnsNameResolverBuilder;

public class ResolverDnsExample {

	public static void main(String[] args) throws Exception {
		EventLoopGroup group = new NioEventLoopGroup(1);
		try (DnsNameResolver resolver =
				new DnsNameResolverBuilder(group.next()).channelType(NioDatagramChannel.class).build()) {
			System.out.println(resolver.resolve("www.google.com").get());
		} finally {
			group.shutdownGracefully();
		}
	}
}
