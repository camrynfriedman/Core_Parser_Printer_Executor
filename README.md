# Core Language Parser, Printer, and Executor
Written by Camryn Friedman 11/22/22

## Overview
The CORE programming language is a made-up language for the purposes of the Principles of Programming Languages class at the Ohio State University (CSE 3341). The goal of this project was to create an Interpreter for the Core language. 

The grammar for the CORE langauge is as follows:
(1)     <prog> ::= program <decl seq> begin <stmt seq> end;
(2)     <decl seq> ::= <decl> | <decl> <decl seq>
(3)     <stmt seq> ::= <stmt> | <stmt> <stmt seq>
(4)     <decl> ::= int <id list>
(5)     <id list> ::= <id> | <id>, <id list>
(6)     <stmt> ::= <assign> | <if> | <loop> | <in> | <out>
(7)     <assign> ::= <id> = <exp>;
(8)     <if> ::= if <cond> then <stmt seq> end; | if <cond> then <stmt seq> else <stmt seq> end;
(9)     <loop> ::= while <cond> loop <stmt seq> end;
(10)    <in> ::= read <id list>;
(11)    <out> ::= write <id list>;
(12)    <cond> ::= <comp> | !<cond> | [<cond> && <cond>] | [<cond> or <cond>]
(13)    <comp> ::= (<op> <comp op> <op>)
(14)    <exp> ::= <fac> | <fac> + <exp> | <fac> - <exp>
(15)    <fac> ::= <op> | <op> * <fac>
(16)    <op> ::= <int> | <id> | (<exp>)
(17)    <comp op> ::= != | == | < | > | <= | >=
(18)    <id> ::= ...as defined by RE...
(19)    <int> ::= ...as defined by RE (only unsigned numbers)

The interpreter was created by first using a previously created Tokenizer which reads in a program text file input and tokenizes it according to the mappings found in [TokenMappings.txt](TokenMappings.txt). The project uses those tokens to 
  
The interpreter consists of the following components:

Tokenizer: Inputs Core program, produces stream of tokens.
Parser: Consumes stream of tokens, produces the abstract parse tree (PT).
Printer: Given PT, prints the original prog. in a pretty format. Used optionally, by user’s choice.
Executor: Given PT (and input data), executes the program.
Full Interpreter: Tokenizer -> Parser -> Printer -> Executor

## User Manual
To compile the project:
Unzip folder or clone repository:


## Known Bugs/Issues
I struggled with running the program as my files were not all connecting with each other.
Neelam is aware of this and has been very accommodating. With that being said, I have not implemented
all possible error checking due to time constraints, and we are under the assumption that we are only
receiving valid input programs. 


