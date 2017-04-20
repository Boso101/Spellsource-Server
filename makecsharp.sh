#!/bin/bash

OUTPUT_DIR=../Minionate/Assets/Plugins/Client

swagger-codegen generate -DsupportingFiles=false -DapiTests=false -DmodelTests=false -DmodelDocs=false -DapiDocs=false -o $OUTPUT_DIR -c "csharpconfig.json"  -i "net/src/main/resources/server.yaml" -l csharp
rm -rf $OUTPUT_DIR/src/
rm -rf $OUTPUT_DIR/docs/
rm -f $OUTPUT_DIR/build.bat
rm -f $OUTPUT_DIR/build.sh
rm -f $OUTPUT_DIR/git_push.sh
rm -f $OUTPUT_DIR/Minionate.Client.sln
rm -f $OUTPUT_DIR/mono_nunit_test.sh
rm -f $OUTPUT_DIR/README.md
rm -rf $OUTPUT_DIR/Scripts/Minionate.Client/Properties
rm -f $OUTPUT_DIR/Scripts/Minionate.Client/packages.config