Hibernate OGM / WildFly / Hot Rod Server demo
=============================================

A simple demo, yet running in a fully featured environment.

Our demo will use plain JPA, but storing data into a remote
Infinispan server using the Hot Rod protocol.
This is achieved using Hibernate OGM, the Hibernate modules
supporting NoSQL, and deploying the application on WildFly.

Meant as a playground for experimentation, the main
benefit being that we automatically fetch and setup those
components so that one can get to try the API quickly.
