# Gist as Json

![Java CI with Maven](https://github.com/JosemyDuarte/gist-as-json/workflows/Java%20CI%20with%20Maven/badge.svg?event=pull_request)

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

This project is a simple PoC. Since Github Gist service returns every raw file as `text/plain` I wanted to return my [Json Resume](https://gist.github.com/JosemyDuarte/7e05cad1dadfec4eb2af44e9a66f8f39) as `application/json`. 

To try this service just go to your browser and type:

`https://gist-as-json-api.herokuapp.com/asJson?url=[YOUR_GIST_TO_RETURN_AS_JSON]`

For example:

`https://gist-as-json-api.herokuapp.com/asJson?url=https://gist.githubusercontent.com/JosemyDuarte/7e05cad1dadfec4eb2af44e9a66f8f39/raw/d64c278204414faa9b0f3873e1b2dc66a0bd5931/resume.json`


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `gist-as-json-1.0-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/gist-as-json-1.0-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/gist-as-json-1.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.
