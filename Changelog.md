# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [Unreleased]

## 0.0.1 - 2018-05-11
### Added
- Option to use medkits during battle
- Medkits
- Medkit drop chance
- Medkit Heals 75% of player health

### Changed
- Medkit drop chance significantly lower than bandage
to make them rare

### Known Issues
- Bandages and Medkits dont add up correctly
- Players health exceeds the maximum of 100%

## 0.0.2 - 2018-05-12
### Added
- Junit Testing to make sure there arn't any errors

### Changed
- Using Apache Mavern instead of one java file to make developing easier
- Package name has been changed to 'com.projectzeus' for use with Maven
- In-game welcome message now prints something better
- Each enemy type now has their own attack damage

### Fixed
- Fixed issue where enemy type names wouldn't show correctly

## 0.0.3 - 2018-05-15
### Added
- Energy Drinks
- Painkillers
- Option to use energy drinks and painkillers during battle

