# Threatening Knights

Finds all situations on a chess-board where two knights threaten each other. Present those
solutions to the user in any way you like.

## Motivation

This is a common task for job-applicants to do and send a few days before a job-interview.

The quality of solutions I've seen differs greatly. Doesn't matter if done by juniors, seniors
or self-acclaimed software-engineers and architect. And still I'm always astonished by the lack
of any automated testing done.

## My solution

Divided projects into three aspects (chess-)rules, solution-finding and rendering with JavaFX.
client allows to browse through all solutions of a default 8x8 chess-boards.

Further parametrization is prepared on code-basis and may be implemented easily.

## Conclusion

I've taken a TDD-approach which worked surprisingly well on the logic parts. This lead to
SOLID-design nearly automatically, even if there are no real interfaces used.

Test-driven-development on the JavaFX-aspect was a bit harder, since there is always some sort
of visual experimentation and exploration on the JavaFX-API. So some tests were made after
the implementation, but ensured a documented behaviour and showed some bugs and unattended
assertions. Still there's a bit to be enhanced on this front.