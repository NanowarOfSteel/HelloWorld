{
  mkShell,
  HelloWorld,
  cowsay
}:

mkShell {
  inherit (HelloWorld) pname version;
  inputsFrom = [ HelloWorld ];
  buildInputs = [ cowsay ];
  shellHook = ''
    echo "nanowar of steel rulez" | cowsay -f dragon >&2
  '';
}
