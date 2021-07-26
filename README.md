# Twitter Mapper

This repo is for a project done in the Micro-Masters program for Software Engineering with the University of British Colombia.

1. Twitter Mapper
   - contains source files for project
   - "main" can be found in TwitterMapper/src/ui/App.java
   - third party libraries are needed to run this application
     - Twitter4j jars
       - to access these files you need to sign up as a Twitter developer
       - navigate to https://apps.twitter.com/ to sign up and acquire the keys needed
         - copy these tokens into *initializeTwitterStream()* in "TwitterMapper/src/twitter/LiveTwitterSource.java"
     - JMapViewer
       - navigate to [OpenStreetMap](https://svn.openstreetmap.org/applications/viewer/jmapviewer/releases/2.3/) and download the "JMapViewer-2.3.zip" file and include the corresponding jar in your project
       - you can also download the source files from the same link as above
2. Diagrams
   - contains package and class diagrams for project