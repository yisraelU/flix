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

import ca.uwaterloo.flix.util.Result
import ca.uwaterloo.flix.util.Result.{Err, Ok}
import org.json4s.JValue
import org.json4s.JsonAST.{JInt, JString}

/**
  * Represents a `CompletionContext` in LSP.
  */
object CompletionContext {
  /**
    * Tries to parse the given `json` value as a [[CompletionContext]].
    */
  def parse(json: JValue): Result[CompletionContext, String] = {
    val triggerKindResult: Result[CompletionTriggerKind, String] = json \\ "triggerKind" match {
      case JInt(i) => Ok(CompletionTriggerKind.from(i.toInt))
      case v => Err(s"Unexpected non-integer triggerKind: '$v'.")
    }
    val triggerCharacter = json \\ "triggerCharacter" match {
      case JString(s) => Some(s)
      case _ => None
    }
    for {
      triggerKind <- triggerKindResult
    } yield CompletionContext(triggerKind, triggerCharacter)
  }
}

/**
  * Contains additional information about the context in which a completion request is triggered.
  *
  * @param triggerKind      How the completion was triggered.
  * @param triggerCharacter The trigger character (a single character) that has trigger code complete.
  *                         Is undefined if `triggerKind !== CompletionTriggerKind.TriggerCharacter`
  */
case class CompletionContext(triggerKind: CompletionTriggerKind, triggerCharacter: Option[String])
