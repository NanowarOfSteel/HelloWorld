{
  lib,
  jre,
  jdk,
  makeWrapper,
  maven,
}:

maven.buildMavenPackage {
  pname = "it.nanowar.ofsteel.helloworld";
  version = "0.0.1";
  src = ./.;

  mvnHash = "sha256-QVRwMC4FREgwojlX5JzTap2eg7HPFNgElIeCVycPOAI=";

  buildInputs = [ jre ];
  nativeBuildInputs = [ jdk makeWrapper maven ];

  installPhase = ''
    mkdir -p $out/bin $out/share/HelloWorld
    jar="$(echo target/HelloWorld-*.jar)"
    install -Dm644 "$jar" $out/share/HelloWorld

    makeWrapper ${jre}/bin/java $out/bin/HelloWorld \
      --add-flags "-cp $out/share/HelloWorld/$(basename -- "$jar")" \
      --add-flags "it.nanowar.ofsteel.helloworld.HelloWorldMainLauncherClass"
  '';

  doInstallCheck = true;
  installCheckPhase = ''
    result="$({ $out/bin/HelloWorld || true; } 2>&1)"

    echo "Result:" >&2
    echo "--------" >&2
    echo "$result" >&2
    echo "--------" >&2

    if [ "$(echo "$result" | grep 'Hello World!' | wc -l)" != 4 ]; then
      echo "Incorrect number of hello world lines" >&2
      exit 1
    fi

    if [ -z "$(echo "$result" | grep NullPointerException | grep joeyDeCaio)" ]; then
      echo "Program should have failed with the correct error message" >&2
      exit 1
    fi
  '';

  meta = with lib; {
    description = "The first example of a source code song";
    longDescription = ''
      Welcome to the Nanowar Of Steel's first GitHub project, and first ever
      example of a source-code song. The aim of this project is to support
      and enforce "True metal programming", that basically means:
      "write code so badly that only you can sing it."
    '';
    mainProgram = "HelloWorld";
    homepage = "https://www.youtube.com/watch?v=yup8gIXxWDU";
    license = {
      fullName = "IronAvantgarde Publishing & Napalm Records License";
      url = "https://napalmrecords.com";
      free = false;
    };
    platforms = platforms.unix;
    maintainers = with maintainers; [ numinit ];
  };
}
