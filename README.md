A builder program that converts scripts that use the groovy
parallel patterns Library components into Groovy scripts.

The script to be built has a name of the form:

path/name.gpp

and the gppBuilder program will create an executable script called:

path/name.groovy

The full path must be specified.

The script does not require the user to specify the 
communication channels nor invoke the processes in parallel.

The examples contained in https://github.com/JonKerridge/GPP_Demos are all built using
this builder program.

The developer is required to construct the data objects used by the application which
are purely sequential in nature and can be based on extant sequential codes, as 
shown in the demonstration applications.  The builder can also deal with examples that 
involve the use of the logging and visualisation system contained within the library.