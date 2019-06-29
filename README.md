Toying around with deploying a Kotlin [Spark](http://sparkjava.com/) web app to AWS Lambda with the Serverless framework.

This is pretty straightforward. Simply run:
`./gradlew deploy` to deploy to dev.

The console output will give you an API Gateway base URL. 
Performing a GET to `<baseUrl>/dev/hello` will return `Hello world.`

I chose Spark because it was recommended for low cold start times on AWS Lambda as noted [here](https://aws.amazon.com/blogs/opensource/java-apis-aws-lambda/):

> Frameworks have different features and performance characteristics. Spring and Spring Boot are extremely powerful when it comes to dependency injection and automatically wiring your application. However, you pay for all this flexibility with the cold start time – reflection is slow. Jersey only performs limited reflection to find its providers and resources. Spark, where everything is “statically linked,” is by far the fastest framework to start.
