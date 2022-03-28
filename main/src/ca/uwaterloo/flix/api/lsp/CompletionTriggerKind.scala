/*
 * Copyright 2022 Magnus Madsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.uwaterloo.flix.api.lsp

import ca.uwaterloo.flix.util.InternalCompilerException

/**
  * Represents a `CompletionTriggerKind` in LSP.
  */
sealed trait CompletionTriggerKind

object CompletionTriggerKind {

  /**
    * Completion was triggered by typing an identifier (24x7 code complete), manual invocation (e.g Ctrl+Space) or via API.
    */
  case object Invoked extends CompletionTriggerKind

  /**
    * Completion was triggered by a trigger character specified by the `triggerCharacters` properties of the `CompletionRegistrationOptions`.
    */
  case object TriggerCharacter extends CompletionTriggerKind

  /**
    * Completion was re-triggered as the current completion list is incomplete.
    */
  case object TriggerForIncompleteCompletions extends CompletionTriggerKind

  /**
    * Returns the [[CompletionTriggerKind]] corresponding to the given `x`.
    */
  def from(x: Int): CompletionTriggerKind = x match {
    case 0 => Invoked
    case 1 => TriggerCharacter
    case 2 => TriggerForIncompleteCompletions
    case _ => throw InternalCompilerException(s"Unexpected CompletionTriggerKind: '$x'.")
  }

}
