/**
 * 
 */
package com.hiperium.commons.client.registry;

import java.io.Closeable;
import java.io.IOException;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.apache.log4j.Logger;

import com.hiperium.commons.client.dto.ServiceDetailsDTO;

/**
 * @author Andres Solorzano
 *
 */
public class ServiceRegister implements Closeable {

	/** The LOGGER property for logger messages. */
	private static final Logger LOGGER = Logger.getLogger(ServiceRegister.class);
	
	/** The property serviceDiscovery. */
	private final ServiceDiscovery<ServiceDetailsDTO> serviceDiscovery;
	/** The property thisInstance. */
	private final ServiceInstance<ServiceDetailsDTO> thisInstance;

	/**
	 * 
	 * @param client
	 * @param port
	 * @param uri
	 * @param name
	 * @param basePath
	 * @param description
	 * @param version
	 * @throws Exception
	 */
	public ServiceRegister(CuratorFramework client, int port, String uri, String name, String basePath, String description, String version) throws Exception {
		UriSpec uriSpec = new UriSpec(uri);
		this.thisInstance = ServiceInstance.<ServiceDetailsDTO> builder()
				.name(name)
				.payload(new ServiceDetailsDTO(version, description))
				.port(port) 
				.uriSpec(uriSpec)
				.build();
		JsonInstanceSerializer<ServiceDetailsDTO> serializer = new JsonInstanceSerializer<ServiceDetailsDTO>(ServiceDetailsDTO.class);
		this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceDetailsDTO.class)
				.client(client)
				.basePath(basePath)
				.serializer(serializer)
				.thisInstance(this.thisInstance)
				.build();
	}

	/**
	 * 
	 * @return
	 */
	public ServiceInstance<ServiceDetailsDTO> getThisInstance() {
		return this.thisInstance;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		this.serviceDiscovery.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void close() throws IOException {
		try {
			this.serviceDiscovery.close(); 
			CloseableUtils.closeQuietly(this.serviceDiscovery);
			LOGGER.info("Closed service name: " + this.thisInstance.getName());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
}
