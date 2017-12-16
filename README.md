
# Exemples de code Java




## Ajouter un exemple au repository

Chaque exemple appartient à une branche orpheline.
La branche `new-example` est une branche comprenant des fichiers communs à tous les exemples.

```sh
> git checkout new-example
> git checkout --orphan branch-name
> echo '# New Example' > README.md
> git add README.md
> git commit -m 'doc: README title'
> git push -u origin branch-name
```
