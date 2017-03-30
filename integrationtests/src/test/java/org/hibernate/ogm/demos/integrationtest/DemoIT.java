package org.hibernate.ogm.demos.integrationtest;

import java.io.IOException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.spec.se.manifest.ManifestDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for the combination of Hibernate OGM and Hibernate Search modules on WildFly,
 * using a remote Infinispan instance over Hot Rod.
 *
 * @author Sanne Grinovero
 */
@RunWith(Arquillian.class)
public class DemoIT {

	@Deployment
	public static Archive<?> deployment() {
		String dependencies = "org.hibernate.ogm:5.1 services, org.hibernate.ogm.infinispan-remote:5.1 services";
		StringAsset manifest = new StringAsset(
				Descriptors.create(ManifestDescriptor.class).attribute("Dependencies", dependencies).exportAsString());
		return ShrinkWrap.create(WebArchive.class, "demo.war").addClasses(DemoIT.class)
				.add(manifest, "META-INF/MANIFEST.MF");
	}

	/*
	private static PersistenceDescriptor persistenceXml() {
		return Descriptors.create( PersistenceDescriptor.class )
				.version( "2.0" )
				.createPersistenceUnit()
					.name( "primary" )
					.provider( "org.hibernate.ogm.jpa.HibernateOgmPersistence" )
					.getOrCreateProperties()
						.createProperty().name( "hibernate.search.default.directory_provider" ).value( "ram" ).up()
						.createProperty().name( "hibernate.ogm.datastore.provider" ).value( "infinispan_remote" ).up()
						.createProperty().name( "hibernate.ogm.infinispan_remote.configuration_resource_name" ).value( "hotrod-client-configuration.properties" ).up()
						.createProperty().name( "wildfly.jpa.hibernate.search.module" ).value( "org.hibernate.search.orm:${hibernate-search.module.slot}" ).up()
				.up().up();
	}
	*/
	@Test
	public void firstTest() throws IOException {
	}

}
