{
  description = "https://www.youtube.com/watch?v=yup8gIXxWDU";
  inputs = {
    flake-parts.url = "github:hercules-ci/flake-parts";
    flake-compat.url = "https://flakehub.com/f/edolstra/flake-compat/1.tar.gz";
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-24.11";
  };
  outputs =
    inputs@{ flake-parts, ... }:
    flake-parts.lib.mkFlake { inherit inputs; } {
      systems = [
        "x86_64-linux"
        "aarch64-linux"
        "aarch64-darwin"
        "x86_64-darwin"
      ];
      perSystem =
        {
          config,
          self',
          inputs',
          pkgs,
          system,
          ...
        }:
        rec {
          _module.args.pkgs = import inputs.nixpkgs {
            inherit system;

            # IronAvantgarde Publishing & Napalm Records License is technically an unfree license
            config.allowUnfree = true;
          };
          packages.default = pkgs.callPackage ./build.nix { };
          devShells.default = pkgs.callPackage ./develop.nix {
            HelloWorld = packages.default;
          };
        };
    };
}
